package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

public class Faculty {
    protected HogwartsStudent[] students;

    public Faculty(HogwartsStudent[] students) {
        this.students = students;
    }

    public HogwartsStudent getRandomStudent() {
        return students[HogwartsService.RANDOM.nextInt(students.length)];
    }
}
