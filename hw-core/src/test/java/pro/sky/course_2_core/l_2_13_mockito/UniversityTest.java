package pro.sky.course_2_core.l_2_13_mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UniversityTest {

    private final Student student = new Student("Eugene", Student.Sex.MALE);
    @Mock
    private StudentValueGenerator studentValueGenerator;

    @InjectMocks
    private University university;

    @Test
    void getAllStudentsTest() {
        assertThat(studentValueGenerator).isNotNull();
        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);
        //Mockito.doReturn(50).when(studentValueGenerator).generateAge(); //not recommended - use variant above^
        university.addStudent(student);
        List<Student> actual = university.getAllStudents();
        assertThat(actual.get(0).getAge()).isEqualTo(50);
    }

    @Test
    void getAllStudentsOver50YearsTest() {
        assertThat(studentValueGenerator).isNotNull();
        Mockito.when(studentValueGenerator.generateAgeInRange(Mockito.anyInt(), Mockito.anyInt())).thenReturn(55);
        university.addStudentAgeInRage(student, 55, StudentValueGenerator.DEFAULT_AGE_MAX);
        List<Student> actual = university.getAllStudents();
        assertThat(actual.get(0).getAge()).isEqualTo(55);
    }

    @Test
    void getAllStudentsTestWithCountAgeGenerate() {
        assertThat(studentValueGenerator).isNotNull();
        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);
        university.addStudent(student);
        List<Student> actual = university.getAllStudents();
        Mockito.verify(studentValueGenerator, Mockito.times(2)).generateAge();
    }

    @Test
    void getAllStudentsInOrderTest() {
        assertThat(studentValueGenerator).isNotNull();
        Mockito.when(studentValueGenerator.generateAgeInRange(50, StudentValueGenerator.DEFAULT_AGE_MAX)).thenReturn(55);
        university.addStudentAgeInRage(student, 50, StudentValueGenerator.DEFAULT_AGE_MAX);
        InOrder inOrder = Mockito.inOrder(studentValueGenerator);
        List<Student> actual = university.getAllStudents();
        inOrder.verify(studentValueGenerator, Mockito.times(2)).generateAge();
        inOrder.verify(studentValueGenerator).generateAgeInRange(Mockito.anyInt(), Mockito.anyInt());
        assertThat(actual.get(0).getAge()).isEqualTo(55);
    }

}