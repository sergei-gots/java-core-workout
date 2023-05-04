package pro.sky.course_2_core.l_2_13_mockito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class University {
    private final StudentValueGenerator studentValueGenerator;
    private final Map<Integer, Student> allStudents = new HashMap<>();
    private int countId = 1;

    public University(StudentValueGenerator studentValueGenerator) {
        this.studentValueGenerator = studentValueGenerator;
    }

    public void addStudent(Student student) {
        student.setId(countId);
        studentValueGenerator.generateAge();
        student.setAge(studentValueGenerator.generateAge());
        allStudents.put(countId, student);
        countId++;
    }

    public void addStudentAgeInRage(Student student, int minAge, int maxAge) {
        student.setId(countId);
        studentValueGenerator.generateAge();
        studentValueGenerator.generateAge();
        student.setAge(studentValueGenerator.generateAgeInRange(minAge, maxAge));
        allStudents.put(countId, student);
        countId++;
    }

    List<Student> getAllStudents() {
        return allStudents.values().stream()
                .collect(Collectors.toList());
    }

    List<Student> getAllStudents(Student.Sex sex) {
        return allStudents.values().stream()
                .filter(student -> student.getSex() == sex)
                .collect(Collectors.toList());
    }
}
