package pro.sky.course_2_core.l_2_12_unit_tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UniversityTest {
    private Student student1;
    private Student student2;
    private Student student3;
    private University university;
    @BeforeEach
    public void setUp() {
        student1 = new Student("Eugene", 35, Student.Sex.MALE);
        student2 = new Student("Marine", 34, Student.Sex.FEMALE);
        student3 = new Student("Alina", 19, Student.Sex.FEMALE);
        university = new University();
        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
    }
    @Test
    public void getAllStudentsTest() {
        List<Student> actual = university.getAllStudents();
        List<Student> expected = new ArrayList<>(List.of(student1, student2, student3));
        Assertions.assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorOnFields("name", "age", "sex")
                .isEqualTo(expected);
    }

    @Test
    public void getAllStudentsNotNullTest() {
        university = new University();
        List<Student> actual = university.getAllStudents();
        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    public void getAllStudentsMaleTest() {
        List<Student> actual = university.getAllStudents(Student.Sex.MALE);
        List<Student> expected = new ArrayList<>(List.of(student1));
        Assertions.assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorOnFields("name", "age", "sex")
                .isEqualTo(expected);
    }

    @Test
    public void getAllStudentsFemaleTest() {
        List<Student> actual = university.getAllStudents(Student.Sex.FEMALE);
        List<Student> expected = new ArrayList<>(List.of(student2, student3));
        Assertions.assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorOnFields("name", "age", "sex")
                .isEqualTo(expected);
    }
}