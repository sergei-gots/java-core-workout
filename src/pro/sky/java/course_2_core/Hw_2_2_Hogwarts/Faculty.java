package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class Faculty {
    protected Student [] students;

    public Student getRandomStudent() {
        return students[HogwartsService.RANDOM.nextInt(students.length)];
    }
}
