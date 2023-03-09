package pro.sky.java.course_1;

import pro.sky.java.util.Homework;

import java.util.Locale;

public class Hw_6 implements Homework {

    public void homework() {

        System.out.println("Homework #1.6\n");

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();

        System.out.println();
    }

    /* Задача 10.
       Напишите программу, которая выводит в консоль таблицу умножения на 2
       в формате:
              2*<i>=m
    */
    private static void task10() {

        System.out.println("Task 10");

        for (int i = 1; i <= 10; i++) {
            System.out.println("2 * " + i + " = " + 2*i);
        }

        System.out.println('\n');
    }


    /* Задача 9.
        Перепишите решение задачи выше при условии,
        что деньги вы откладывать будете на счёт в банк под проценты — 12% годовых.
        Выведите сумму накоплений за каждый месяц в консоль в формате:
            «Месяц …, сумма накоплений равна … рублей».
     */
    private static void task9() {

        System.out.println("Task 9");

        double total = 0;

        for (int i = 1; i <= 12; i++) {
            total *= 1.01;
            total += 29_000;
            System.out.printf(Locale.US, "Месяц " + i + ", сумма накоплений равна %.2f рублей.\n", total);
        }

        System.out.println();
    }


    /* Задача 8.
        Посчитайте с помощью цикла for сумму годовых накоплений,
        если каждый месяц вы будете откладывать по 29 000 рублей.
        Выведите сумму накоплений за каждый месяц в консоль в формате: «Месяц …, сумма накоплений равна … рублей».
     */
    private static void task8() {

        System.out.println("Task 8");

        int total = 0;

        for (int i = 1; i <= 12; i++) {
            total += 29_000;
            System.out.println("Месяц " + i + ", сумма накоплений равна " + total + " рублей.");
        }

        System.out.println();
    }

    /* Задача 5.
        Напишите программу, которая выводит в консоль последовательность чисел:
        1 2 4 8 16 32 64 128 256 512
     */
    private static void task7() {

        System.out.println("Task 7");

        for (int i = 2; i <= 512; i *= 2) {
            System.out.print(i + " ");
        }

        System.out.println('\n');
    }

    /* Задача 5.
        Напишите программу, которая выводит в консоль последовательность чисел:
        7 14 21 28 35 42 49 56 63 70 77 84 91 98
     */
    private static void task6() {

        System.out.println("Task 6");

        for (int i = 7; i <= 98; i += 7) {
            System.out.print(i + " ");
        }

        System.out.println('\n');
    }

    /* Задача 5.
        Напишите программу, которая выводит в консоль все високосные года,
         начиная с 1904 года до 2096.
         В консоль результат должен выводиться в формате:
         «… год является високосным».
     */
    private static void task5() {

        System.out.println("Task 5");

        for (int i = 1904; i <= 2096; i += 4) {
            System.out.println(i + "-й год является високосным.");
        }

        System.out.println();
    }

    /*Задача 4.
        Выведите в консоль все числа от 10 до −10 от бо́льшего числа к меньшему.
    */
    private static void task4() {

        System.out.println("Task 4");

        for (int i = 10; i >= -10; i = i - 1) {
            System.out.print(i + " ");
        }

        System.out.println('\n');
    }

    /* Задача 3.
        Выведите в консоль все четные числа от 0 до 17
    */
    private static void task3() {

        System.out.println("Task 3");

        for (int i = 0; i < 17; i = i + 2) {
            System.out.print(i + " ");
        }

        System.out.println("\n");
    }

    /* Задача 2.
        С помощью цикла for выведите в консоль все числа от 10 до 1.
    */
    private static void task2() {

        System.out.println("Task 2");

        for (int i = 10; i > 0; i = i - 1) {
            System.out.print(i + " ");
        }

        System.out.println("\n");
    }

    /* Задача 1.
        С помощью цикла for выведите в консоль все числа от 1 до 10.
    */
    private static void task1() {

        System.out.println("Task 1");

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n");
    }


}
