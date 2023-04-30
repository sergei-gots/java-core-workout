package pro.sky.course_2_core.hw_2_2_hogwarts;

import pro.sky.course_2_core.hw_2_2_hogwarts.hogwarts.Hogwarts;
import pro.sky.course_2_core.hw_2_2_hogwarts.hogwarts.HogwartsService;
import pro.sky.util.Homework;

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
