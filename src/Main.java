public class Main {

    enum HW_NUMBER {
        HW_1,
        HW_2
    }
    public static void main(String[] args) {

        HW_NUMBER hwNumber = HW_NUMBER.HW_2;
        switch(hwNumber) {
            case HW_1: homework1(); break;
            case HW_2: homework2(); break;
        }

    }
    public static void homework2() {

        System.out.println("Homework # 2");

        task2_1();
        task2_2();
        task2_3();
        task2_4();
        task2_5();
        task2_6();
        task2_7();
        task2_8();
    }
    /*  Задача 8

        К вам пришел руководитель с задачей автоматизировать повышение зарплаты, а также провести расчет для следующих сотрудников:

        Маша получает 67 760 рублей в месяц.
        Денис получает 83 690 рублей в месяц.
        Кристина получает 76 230 рублей в месяц.

        Каждому нужно увеличить зарплату на 10% от текущей месячной.
        Дополнительно руководитель попросил посчитать разницу между годовым доходом с нынешней зарплатой и после повышения.

        Посчитайте, сколько будет получать каждый из сотрудников, а также разницу между годовым доходом до и после повышения.
        Выведите в консоль информацию по каждому сотруднику. Например: «Маша теперь получает ... рублей. Годовой доход вырос на ... рублей»
    */
    private static void task2_8() {

        System.out.println("Task 8");

        int nSalaryOfMasha  = 67_760;
        int nSalaryOfDen    = 83_960;
        int nSalaryOfChristy= 76_230;

        int nSalaryOfMashaNew   = nSalaryOfMasha * 110 / 100;
        int nSalaryOfDenNew     = nSalaryOfDen * 110 / 100;
        int nSalaryOfChristyNew = nSalaryOfChristy * 110 / 100;

        int nYearSalaryDiffOfMasha  = (nSalaryOfMashaNew - nSalaryOfMasha) * 12;
        int nYearSalaryDiffOfDen    = (nSalaryOfDenNew - nSalaryOfDen) * 12;
        int nYearSalaryDiffOfChristy= (nSalaryOfChristyNew - nSalaryOfChristy) * 12;

        System.out.println("Маша теперь получает " + nSalaryOfMashaNew + " рублей. Годовой доход вырос на " +
                nYearSalaryDiffOfMasha + " рублей.");
        System.out.println("Денис теперь получает " + nSalaryOfDenNew + " рублей. Годовой доход вырос на " +
                nYearSalaryDiffOfMasha + " рублей.");
        System.out.println("Кристина теперь получает " + nSalaryOfChristyNew + " рублей. Годовой доход вырос на " +
                nYearSalaryDiffOfChristy + " рублей.");

        System.out.println();
    }

    /*  Задача 7
        Спортсмену, чтобы оставаться в своей весовой категории, нужно сбросить 7 кг.
        Тренер скорректировал рацион так, чтобы спортсмен мог терять в весе от 250 до 500 грамм в день.
        Посчитайте, сколько дней уйдет на похудение, если спортсмен будет терять каждый день по 250 грамм,
        а сколько — если каждый день будет худеть на 500 грамм.

        Посчитайте, сколько может потребоваться дней в среднем, чтобы добиться результата похудения.
    */
    private static void task2_7() {

        System.out.println("Task 7");

        int diffMinPerDay = 250;
        int diffMaxPerDay = 500;

        int diffTotal = 7000;

        int daysMin = diffTotal / diffMaxPerDay;
        int daysMax = diffTotal / diffMinPerDay;

        int daysAverage = diffTotal / ((diffMaxPerDay + diffMinPerDay) / 2);

        System.out.println("Количество дней для достижения результата: ");
        System.out.println("\t минимум - " + daysMin + " дней;");
        System.out.println("\t максимум - " + daysMax + " дней;");
        System.out.println("\t в среднем - " + daysAverage + " дней.");

        System.out.println();
    }

    /*  Задача 6
        Спортсмены следят за своим весом и тщательно относятся к тому, что и сколько они съедают.
    Вот один из рецептов, по которому спортсмен готовит себе завтрак:
        Бананы — 5 штук (1 банан — 80 грамм).
        Молоко — 200 мл (100 мл = 105 грамм).
        Мороженое-пломбир — 2 брикета по 100 грамм.
        Яйца сырые – 4 яйца (1 яйцо — 70 грамм).
        Смешать всё в блендере — и готово.
    Подсчитайте вес (количество граммов) такого спортзавтрака,
    а затем переведите его в килограммы.
    Результат в граммах и килограммах напечатайте в консоль.
        Важное условие: если в рецепт нужно добавить несколько единиц какого-то продукта
    (с определенным весом), то нужно умножать количество единиц на вес в граммах.
    Например, если в рецепте указано, что нужно добавить 5 бананов по 80 грамм,
    то нужно количество бананов (5) умножить на вес одного (80 грамм),
    а не считать самим общую сумму граммов.
     */
    private static void task2_6() {

        System.out.println("Task 6");

        int bananasCount = 5;
        float bananaWeight = 80;

        int milkAmount = 200;
        float milkDensity = 1.05F;

        int iceCreamCount = 2;
        float iceCreamWeight = 100;

        int eggsCount = 4;
        float eggWeight = 70;

        float outputWeightGrams =
                bananasCount * bananaWeight +
                milkAmount * milkDensity +
                iceCreamCount * iceCreamWeight +
                eggsCount * eggWeight;
        float gramsPerKilo = 1000;
        float outputWeightKg = outputWeightGrams / gramsPerKilo;

        System.out.println("Вес готового завтрака составляет " + outputWeightGrams + " гр. или " +
                outputWeightKg + " кг.");

        System.out.println();
    }

    /* Задача 5
        На ремонт школы нужно 120 банок краски двух цветов: белой и коричневой.
        На один класс уходит 2 банки белой и 4 банки коричневой краски.
        Сколько банок каждой краски было куплено?

        Выведите результат задачи в консоль в формате:
        «В школе, где … классов, нужно … банок белой краски и … банок коричневой краски».
    */
    private static void task2_5() {
        System.out.println("Task 5");

        int nTinsTotal = 120;
        int nWhitePaintPerClassroom = 2;
        int nBrownPaintPerClassroom = 4;
        int nTinsPerClassroom = nWhitePaintPerClassroom + nBrownPaintPerClassroom;

        int nClassroomTotal = nTinsTotal / nTinsPerClassroom;
        int nWhitePaintTinsTotal = nWhitePaintPerClassroom * nClassroomTotal;
        int nBrownPaintTinsTotal = nBrownPaintPerClassroom * nClassroomTotal;

        System.out.println("В школе, где " + nClassroomTotal + " классов, нужно " +
                nWhitePaintTinsTotal + " банок белой краски и " +
                nBrownPaintTinsTotal + " банок коричневой краски.");

        System.out.println();
    }

    /* Задача 4
        Производительность машины для изготовления бутылок — 16 бутылок за 2 минуты.
        Какая производительность машины будет:
            за 20 минут,
            в сутки,
            за 3 дня,
            за 1 месяц?
        Рассчитывайте производительность работы машины в том случае,
        если она работает без перерыва заданный промежуток времени.
        Результаты подсчетов выведите в консоль в формате:
        «За … машина произвела … штук бутылок».
     */
    public static void task2_4() {

        System.out.println("Task 4");

        int bottlesIn2Min = 16;
        int bottlesIn20Min = bottlesIn2Min * 10;
        int bottlesPerDay = bottlesIn20Min * 3 * 24;
        int bottlesPer3Days = bottlesPerDay * 3;
        int bottlesPerMonthMin = bottlesPerDay * 28;
        int bottlesPerMonthMax = bottlesPerDay * 31;


        System.out.println("За 20 минут машина произведёт " + bottlesIn20Min + " бутылок.");
        System.out.println("За сутки машина произведёт " + bottlesPerDay + " бутылок.");
        System.out.println("За 3 дня машина произведёт " + bottlesPer3Days + " бутылок.");
        System.out.println("За месяц машина произведёт от " + bottlesPerMonthMin +
                " до " + bottlesPerMonthMax + "  бутылок.");

        System.out.println();
    }

    /*Задача 3
    Три школьных учителя, Людмила Павловна, Анна Сергеевна и Екатерина Андреевна, ведут три класса.
    У Людмилы Павловны — 23 ученика ,
    у Анны Сергеевны — 27 учеников,
    у Екатерины Андреевны — 30 учеников.
    Три учительницы закупили все вместе 480 листов бумаги на все три класса. Посчитайте, сколько достанется листов каждому ученику.
    Результат задачи выведите в консоль в формате:
    «На каждого ученика рассчитано … листов бумаги».
    Для объявления переменных не используйте тип var.
 */
    public static void task2_3() {

        System.out.println("Task 3");

        int studentsNumber1 = 23;
        int studentsNumber2 = 27;
        int studentsNumber3 = 30;

        int papersNumber = 480;

        int sheetsPerStudent = papersNumber / (studentsNumber1 + studentsNumber2 + studentsNumber3);

        System.out.println("На каждого ученика рассчитано "
                + sheetsPerStudent + " листов бумаги.");

        System.out.println();
    }

    /* Задача 2
    Ниже дан список различных значений.
    Инициализируйте переменные, используйте изученные ранее типы переменных.
     Значения:
            27.12
            987 678 965 549
            2,786
            569
            -159
            27897
            67
    */
    public static void task2_2() {

        System.out.println("Task 2 (doesn't have any output)");

        float twentySevenPointTwelve = 27.12F;
        long aboutNineE11 = 987_678_965_549L;
        float twoPointSevenEightSix = 2.786F;
        short minusHundredAndFiftyNine = -159;
        short twentySevenThousandsEightHundredNinetySeven = 27897;
        byte sixtySeven = 67;

        System.out.println();
    }

    /*Задача 1
        Объявите переменные типа int, byte, short, long, float, double.
        Название переменных может быть любым, но если состоит из двух слов и более,
        должно соответствовать правилу camelCase.
        Выведите в консоль значение каждой переменной в формате
        «Значение переменной … с типом … равно …».
     */
    public static void task2_1() {

        System.out.println("Task 1");

        int maxInt = 2_147_483_647;
        byte maxByte = 127;
        short maxShort = 32_767;
        long theLongestLong = 9_223_372_036_854_775_807L;
        float maxFloat = 3.4E+38F;
        double maxDouble =  1.7E+308D;

        System.out.println("Значение переменной maxInt с типом int равно " + maxInt);
        System.out.println("Значение переменной maxByte с типом byte равно  = " + maxByte);
        System.out.println("Значение переменной maxShort с типом short равно  = " + maxShort);
        System.out.println("Значение переменной theLongestLong с типом long равно  = " + theLongestLong);
        System.out.println("Значение переменной maxFloat с типом float равно  = " + maxFloat);
        System.out.println("Значение переменной maxDouble с типом double равно  = " + maxDouble);

        System.out.println();
    }


    public static void homework1() {

        System.out.println("Homework # 1");

            task1_3();
            task4();
            task5();
            task6_7();
            task8();
    }

    public static void task1_3() {

        System.out.println("Task 1");

        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;

        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);
        System.out.println("paper = " + paper);
        System.out.println();


        System.out.println("Task 2");

        dog += 4;
        cat += 4;
        paper += 4;

        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);
        System.out.println("paper = " + paper);
        System.out.println();

        System.out.println("Task 3");

        dog -= 3.5;
        cat -= 1.6;
        paper -= 7369;

        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);
        System.out.println("paper = " + paper);
        System.out.println();
    }

/*  Задача 4
    Инициализируйте (присвойте значение) переменную friend значением 19.
    Увеличьте значение переменной на 2, после чего поделите значение на 7.
    После каждой операции выводите значение переменной в консоль. В итоге у вас должно быть выведено 3 значения одной переменной.
    Для решения этой задачи используйте тип переменной var.
*/
    public static void task4() {

        System.out.println("Task 4");

        var friend = 19;
        System.out.println("friend = " + friend);

        friend *= 2;
        System.out.println("friend = " + friend);

        friend /= 7;
        System.out.println("friend = " + friend);

        System.out.println();
    }

    /*  Задача 5
        Инициализируйте переменную frog значением 3.5.
        Увеличьте переменную в 10 раз и поделите на 3.5. Добавьте к последнему значению переменной 4.
        После каждой операции выводите значение переменной в консоль. В итоге у вас должно быть выведено 4 значения одной переменной.
        Для решения этой задачи используйте тип переменной var.
     */
    public static void task5() {

        System.out.println("Task 5");

        var frog = 3.5;
        System.out.println("frog = " + frog);

        frog *= 10;
        System.out.println("frog = " + frog);

        frog /= 3.5;
        System.out.println("frog = " + frog);

        frog +=4;
        System.out.println("frog = " + frog);

        System.out.println();

    }

/*  Задача 6
    В боксе перед каждым боем спортсменов взвешивают. Это делают для того, чтобы убедиться,
    что боксеры соответствуют своей весовой категории, и бой будет честным.
    Вес одного боксера — 78.2 kg.
    Вес второго боксера — 82.7 kg.
    Подсчитайте и выведите в консоль общий вес двух бойцов.
    Подсчитайте и выведите в консоль разницу между весами бойцов. Для решения этой задачи используйте тип переменной var.

    Задача 7
    Вычислите разницу весов спортсменов, используйте 2 способа:
    Вычитание из большего веса меньшего.
    С помощь функции остаток от деления.
*/
    public static void task6_7() {

        System.out.println("Task 6");

        var boxerWeight1 = 78.2;
        var boxerWeight2 = 82.7;

        System.out.println("Boxer#1 weight = " + boxerWeight1 + " kg");
        System.out.println("Boxer#2 weight = " + boxerWeight2 + " kg");


        var totalWeight = boxerWeight1 + boxerWeight2;
        System.out.println("Total weight = " + totalWeight + " kg");

        var weightDiffSubtracted = boxerWeight2 - boxerWeight1;
        System.out.println("Weight difference = " + weightDiffSubtracted + " kg");

        System.out.println();

        System.out.println("Task 7");

        System.out.println("Weight diff. calculated with subtraction = " + weightDiffSubtracted + " kg");

        var weightDiffDivided = boxerWeight2 % boxerWeight1;
        System.out.println("Weight diff. calculated with remainder of division = " + weightDiffDivided + " kg");

        System.out.println();

    }

    /* Задача 8
        Решите задачу с помощью функций сложения, вычитания, умножения и деления.
        640 часов работы поделено между сотрудниками. Если каждый сотрудник посвящает работе 8 часов,
        то сколько всего работников в компании? Выведите результат задачи в консоль в формате:
         «Всего работников в компании — … человек».

        Посчитайте, сколько часов работы должно быть поделено между сотрудниками,
        если в компании работает на 94 человека больше.
        Выведите результат задачи в консоль в формате: «Если в компании работает … человек,
        то всего … часов работы может быть поделено между сотрудниками».
     */
    public static void task8() {

        System.out.println("Task 8");

        var workingHoursTotal = 640;
        var workingHoursPerPerson = 8;
        var employeesNumber = workingHoursTotal/workingHoursPerPerson;

        System.out.println("Общее количество работников в компании составляет " + employeesNumber + " человек.");

        var employeesNumber1 = employeesNumber + 94;
        var workingHoursTotal1 = employeesNumber1 * workingHoursPerPerson;

        System.out.println("Если в компании будет работать " + employeesNumber1 + " человека,\n" +
                "то между сотрудниками может быть поделено " + workingHoursTotal1 + " часов работы.");

        System.out.println();
    }


}