package pro.sky.java.course_2_core.Hw_2_2_Hogwarts;

import pro.sky.java.util.Homework;

public class App implements Homework {
    public static void main(String[] args) {
        new App().homework();
    }

    @Override
    public void homework() {
        Hogwarts hogwarts = HogwartsService.createHogwartsInsance();
        HogwartsService.printRandomStudentInfo(hogwarts);
        HogwartsService.printRandomStudentsCompareInfo(hogwarts);
        HogwartsService.printRandomStudentsTheSameFacultyCompareInfo(hogwarts);
    }
}
