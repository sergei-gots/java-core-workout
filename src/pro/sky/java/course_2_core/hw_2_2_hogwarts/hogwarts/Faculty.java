package pro.sky.java.course_2_core.hw_2_2_hogwarts.hogwarts;

public class Faculty {
    protected HogwartsStudent[] students;

    public Faculty(HogwartsStudent[] students) {
        this.students = students;
    }

    public HogwartsStudent getRandomStudent() {
        return students[HogwartsService.RANDOM.nextInt(students.length)];
    }
}
