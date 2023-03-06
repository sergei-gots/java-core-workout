package pro.sky.java.course1;

import pro.sky.java.util.Homework;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class Hw_9 implements Homework {

    private final static int DAYS_IN_MONTH = 30;

    public void homework() {

        System.out.println("Homework 1.9. Arrays (part 2)");

        task1();
        task2();
        task3();
        task4();

        System.out.println();
    }

    /* Задача 4
        В бухгалтерской книге появился баг. Что-то пошло нет так — фамилии и имена сотрудников начали отображаться
        в обратную сторону. Т. е. вместо «Иванов Иван» мы имеем «навИ вонавИ».
        Данные с именами сотрудников хранятся в виде массива символов — char[ ].
        Напишите код, который в случае такого бага будет выводить фамилии и имена сотрудников в корректном виде.
        В качестве данных для массива используйте:

        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        В результате в консоль должно быть выведено: Ivanov Ivan.
        Важно: не используйте дополнительные массивы для решения этой задачи.
        Необходимо корректно пройти по массиву циклом и распечатать его элементы в правильном порядке.
     */
    private static void task4() {
        System.out.println("Task 4:");

        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        for (int i = 0; i < reverseFullName.length/2; i++) {
            char buff = reverseFullName[i];
            reverseFullName[i] = reverseFullName[reverseFullName.length - i - 1];
            reverseFullName[reverseFullName.length - i - 1] = buff;
        }

        for (char ch :
                reverseFullName) {
            System.out.print(ch);
        }

        System.out.println("\n");
    }

    /*
        Задача 3.
        Теперь бухгалтерия хочет понять, какую в среднем сумму компания тратила в течение 30 дней.
        Напишите программу, которая посчитает среднее значение трат за месяц
        (то есть сумму всех трат за месяц поделить на количество дней),
        и выведите в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
        Важно помнить: подсчет среднего значения может иметь остаток, то есть быть не целым, а дробным числом.
     */
    private static void task3() {

        System.out.println("Task3:");

        int[] array = generateRandomArray();
        int sum = getSum(array);
        double av = (double) sum / DAYS_IN_MONTH;

        System.out.printf("Средняя сумма трат за месяц составила %,.2f рублей.\n", av);

        System.out.println();

    }

    /* Задача 2.
        Также бухгалтерия попросила найти минимальную и максимальную трату за день.
        Напишите программу, которая решит эту задачу, и выведите в консоль результат в формате:
        «Минимальная сумма трат за день составила … рублей. Максимальная сумма трат за день составила … рублей».
     */
    private static void task2() {
        System.out.println("Task2:");

        int[] array = generateRandomArray();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.FRANCE);

        for (final int i : array) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        System.out.println("Минимальная сумма трат за день составила " + numberFormat.format(min) + " рублей.");
        System.out.println("Максимальная сумма трат за день составила " + numberFormat.format(max) + " рублей.");

        System.out.println();
    }

    /* Задача 1
        Бухгалтеры попросили посчитать сумму всех выплат за месяц.
        Напишите программу, которая решит эту задачу, и выведите в консоль результат в формате: «Сумма трат за месяц составила … рублей».
    */
    private static void task1() {
        System.out.println("Task1:");

        int[] array = generateRandomArray();
        int sum = getSum(array);
        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.FRANCE);
        System.out.println("Сумма трат за месяц составила " + numberFormat.format(sum) + " рублей.");

        System.out.println();
    }

    private static int getSum(int[] array) {
        int sum = 0;
        for (final int i : array) {
            sum += i;
        }
        return sum;
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[DAYS_IN_MONTH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }

        return arr;

    }


}