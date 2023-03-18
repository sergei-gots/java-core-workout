package pro.sky.java.course_1_basics;

import pro.sky.java.util.Homework;

import java.text.NumberFormat;
import java.util.Locale;

public class Hw_7  implements Homework {

    public void homework() {

        System.out.println("Homework #1.7\n");

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();

        System.out.println();
    }

    /*
          Задача 8
              Нам нужно написать астрономическое приложение, которое считает, когда над Землей пролетает комета.
                  Известно, что комета пролетает каждый 79-й год, начиная с нулевого.
                  В консоль нужно вывести все годы за последние 200 лет, когда появлялась комета,
              а также следующий год ее появления (ближайшие 100 лет).
                  Для вычисления периода можно создать две дополнительные переменные,
              которые содержат год за 200 лет до текущего (из созданной ранее переменной)
              в качестве старта и 100 лет после в качестве завершения периода расчета.
              В результате решения задачи в консоли должен получиться следующий результат:

                  1896
                  1975
                  2054
       */
    private static void task8() {
        System.out.println("Task 8");

        int currentYear = 2022;
        int firstYearUnderView = currentYear - 200;
        int lastYearUnderView = currentYear + 100;

        final int cometPeriod = 79;
        int firstAppearanceAD = 0;

        int appearanceWithinPeriodUnderView =
                firstYearUnderView + cometPeriod -
                        (firstYearUnderView - firstAppearanceAD -
                                ((firstYearUnderView - firstAppearanceAD) / cometPeriod) * cometPeriod);

        while (appearanceWithinPeriodUnderView <= lastYearUnderView) {
            System.out.println(appearanceWithinPeriodUnderView);
            appearanceWithinPeriodUnderView += cometPeriod;
        }

        System.out.println();
    }

    /* Задача 7
        В компании пятница — отчетный день.
        Нужно написать программу, которая считает дни месяца по датам, определяет, какой день пятница,
        и выводит сообщение с напоминанием, что нужно подготовить еженедельный отчет.

        Создайте переменную типа int, которая хранит в себе номер первой пятницы месяца (число от 1 до 7).
        Выведите на каждую пятницу месяца (включая полученную) сообщение следующего вида: «Сегодня пятница, ...-е число.
        Необходимо подготовить отчет».
        В нашем месяце 31 день.
        В результате у вас должно получиться от 4 до 5 сообщений с напоминаниями по разным датам.
     */
    private static void task7() {
        System.out.println("Task 7");

        final int daysInWeek = 7;
        int dateOfFriday = 3;
        int daysInMonth = 31;


        while (dateOfFriday <= daysInMonth) {
            System.out.println("Сегодня пятница, " + dateOfFriday + "-е число. Необходимо подготовить отчёт.");
            dateOfFriday += daysInWeek;
        }

        System.out.println();
    }

    /* Задача 6.
        Василий решил, что будет копить деньги ближайшие 9 лет.
        Он хочет знать, какой будет сумма его накоплений каждые полгода на протяжении этих 9 лет.
        Исходная сумма всё та же — 15 тысяч рублей, проценты банка – 7% ежемесячно.
        Напишите программу, которая будет выводить сумму накоплений за каждые полгода в течение 9 лет.
     */
    private static void task6() {
        System.out.println("Task 6");

        final double depositInterest = 1.07;

        final int monthsInYear = 12;
        final int yearsAmount = 9;
        final int monthsTotal = yearsAmount * monthsInYear;

        double amount = 15_000;
        int monthsCount = 0;

        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.FRANCE);

        while (monthsCount < monthsTotal) {
            amount *= depositInterest;
            if ((++monthsCount % 6 == 0))
                System.out.println("Месяц " + monthsCount +
                        ", сумма накоплений равна " + numberFormat.format(amount) + " рублей.");
        }

        System.out.println("По истечении " + yearsAmount + " лет накопления на Васином счёте составят " +
                numberFormat.format(amount) + " рублей.\n");
    }

    /*  Задача 5.
        Видоизмените программу таким образом, чтобы в консоль выводились не все месяцы подряд,
        а только каждый шестой. Должны быть видны накопления за 6, 12, 18, 24-й и следующие месяцы.
     */
    private static boolean reportMonthly = true;

    private static void task5() {
        reportMonthly = true;
        tasks4_5();
    }

    /* Задача 4.
        Василий решил положить деньги на накопительный счет, где каждый месяц к сумме его вклада добавляется еще 7%.
        Первоначальная сумма вклада — 15 тысяч рублей.
        Вычислите и выведите в консоль, сколько месяцев Василию нужно будет копить,
        чтобы собрать сумму в 12 миллионов рублей при условии,
        что процент банка от накоплений не меняется, а всегда равен 7%.
        Выведите в консоль результат программы с указанием суммы накоплений по каждому месяцу.

        Задача 5.
        Видоизмените программу таким образом, чтобы в консоль выводились не все месяцы подряд,
        а только каждый шестой. Должны быть видны накопления за 6, 12, 18, 24-й и следующие месяцы.
    * */
    private static void task4() {

        System.out.println("Task 4");
        reportMonthly = false;
        tasks4_5();
    }

    private static void tasks4_5() {

        final double initialAmount = 15_000;
        final double depositInterest = 1.07;
        final double targetAmount = 12_000_000;


        double amount = initialAmount;
        int monthsCount = 0;

        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.FRANCE);

        while (amount < targetAmount) {
            amount *= depositInterest;
            if ((++monthsCount % 6 == 0) || reportMonthly)
                System.out.println("Месяц " + monthsCount +
                        ", сумма накоплений равна " + numberFormat.format(amount) + " рублей.");
        }

        System.out.println("Для накопления на счёте " + numberFormat.format(targetAmount) +
                " рублей Васе потребуется подождать " + monthsCount + " месяцев.\n");
    }

    /* Задача 3.
        В стране Y население равно 12 миллионов человек.
        Рождаемость составляет 17 человек на 1000, смертность — 8 человек.
        Рассчитайте, какая численность населения будет через 10 лет, если показатели рождаемости и смертности постоянны.
        В консоль выведите результат операции на каждый год в формате: «Год …, численность населения составляет …».
    * */
    private static void task3() {
        System.out.println("Task 3");

        int population = 12_000_000;

        final int fertility = 17;
        final int mortality = 8;
        final int incrementPro1000PerYear = fertility - mortality;

        //NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.FRANCE);

        for (int i = 0; i < 10; i++) {
            population += (population / 1000) * incrementPro1000PerYear;
            System.out.printf(Locale.FRANCE, "Год " + (i + 1) + ", численность населения составляет ");
            System.out.printf("%,d.\n", population);
            //System.out.println(numberFormat.format(population) + ".");
        }

        System.out.println();
    }


    /*Задача 2.
            Выведите в одну строку через пробел числа от 1 до 10 с помощью цикла while.
            На следующей строке выведите числа в обратном порядке от 10 до 1 с помощью цикла for.
            Для обоих циклов можно использовать как одну общую переменную, так и в каждом цикле свою.
            Не забудьте выполнить переход на новую строку между двумя циклами.

            В результате программы вывод должен получиться следующий:

                1 2 3 4 5 6 7 8 9 10
                10 9 8 7 6 5 4 3 2 1
    * */
    private static void task2() {

        System.out.println("Task 2");

        int i = 0;

        while (i < 10) {
            System.out.print(++i + " ");
        }
        System.out.println();

        for (; i > 0; ) {
            System.out.print(i-- + " ");
        }

        System.out.println('\n');
    }

    /*  Задача 1.
            Продолжите работать с кодом, который вы написали в предыдущем уроке — в задачах с накоплениями.
            С помощью цикла while посчитайте, сколько месяцев потребуется, чтобы накопить 2 459 000 рублей при условии,
            что первоначально мы имеем 0 рублей и готовы откладывать по 15 тысяч рублей.
            Результат программы должен быть выведен в консоль с тем количеством месяцев,
            которое необходимо для накопления данной суммы. Формат сообщения: «Месяц …, сумма накоплений равна … рублей».
     */
    private static void task1() {
        System.out.println("Task 1");

        int total = 0;
        int monthsCount = 0;

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);

        while (total < 2_459_000) {
            total += 15_000;
            monthsCount++;

            System.out.println("Месяц " + monthsCount +
                    ", сумма накоплений равна " + numberFormat.format(total) + " рублей.");
        }

        System.out.println();
    }
}
