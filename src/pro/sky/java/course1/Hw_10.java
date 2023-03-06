package pro.sky.java.course1;

import pro.sky.java.util.Homework;

public class Hw_10  implements Homework {

    public void homework() {

        System.out.println("Homework 1.10 \"Class String\"");

        task1();
        task2();
        task3();
    }

    /**
     * Задача 3.
     * Система, в которой мы работаем, не принимает символ «ё».
     * Напишите программу, которая заменяет символ «ё» на символ «е».
     *
     * В качестве исходных данных используйте строку fullName и данные в ней — "Иванов Семён Семёнович".
     * Выведите результат программы в консоль в формате: «Данные ФИО сотрудника — ...».
     */
    private static void task3() {
        System.out.println("Task #3:");

        String fullName = "Иванов Семён Семёнович";

        fullName = fullName.replace("ё", "е");

        System.out.println("Данные ФИО сотрудника  - " + fullName);

        System.out.println();
    }

    /**
     * Задача 2.
     * Для ежемесячного отчета и ведения документации бухгалтерии нужны Ф. И. О. сотрудников,
     * полностью написанные заглавными буквами (верхним регистром).
     * <p>
     * Напишите программу, которая изменит написание Ф. И. О.
     * сотрудника с "Ivanov Ivan Ivanovich" на полностью заглавные буквы.
     * <p>
     * В качестве строки с исходными данными используйте строку fullName.
     * <p>
     * Результат программы выведите в консоль в формате: "Данные ФИО сотрудника для заполнения отчета — …"
     */
    private static void task2() {
        System.out.println("Task #2:");

        String fullName = getTestFIO();

        fullName = fullName.toUpperCase();

        System.out.println("Данные ФИО сотрудника для заполнения отчёта - " + fullName);

        System.out.println();
    }

    /**
     * Задача 1.
     * Представьте, что вы работаете в небольшой компании. Данные сотрудников хранятся в неструктурированном формате.
     * Бухгалтерия попросила написать программу, в которой можно работать с Ф. И. О. сотрудников.
     * <p>
     * Напишите четыре строки:
     * <p>
     * С именем firstName — для хранения имени.
     * С именем middleName — для хранения отчества.
     * С именем lastName — для хранения фамилии.
     * С именем fullName — для хранения Ф. И. О. сотрудника в формате "Фамилия Имя Отчество".
     * Выведите в консоль фразу: «ФИО сотрудника — …».
     * <p>
     * В качестве данных для задачи используйте "Ivanov Ivan Ivanovich".
     */
    private static void task1() {
        System.out.println("Task #1:");

        String fullName = getTestFIO();

        System.out.println("ФИО сотрудника - " + fullName);

        System.out.println();
    }

    private static String getTestFIO() {

        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = lastName + ' ' + middleName + ' ' + firstName;
        return fullName;
    }
}
