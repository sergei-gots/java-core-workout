package pro.sky.java.course_2_core.Hw_2_2_hogwarts;

import pro.sky.java.util.Homework;

public class App implements Homework {
    public static void main(String[] args) {
        new App().homework();
    }

    @Override
    public void homework() {
        Hogwarts hogwarts = HogwartsService.createHogwartsInstance();
        HogwartsService.printRandomStudentInfo(hogwarts);
        HogwartsService.printRandomStudentsCompareInfo(hogwarts);
        HogwartsService.printRandomStudentsTheSameFacultyCompareInfo(hogwarts);
    }
}
