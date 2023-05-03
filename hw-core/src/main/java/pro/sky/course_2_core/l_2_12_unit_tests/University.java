package pro.sky.course_2_core.l_2_12_unit_tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class University {
    private Map<Integer, Student> allStudents = new HashMap<>();
    private int countId = 1;

    public void addStudent(Student student) {
        student.setId(countId);
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
