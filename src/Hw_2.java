public class Hw_2 implements Homework {

    public void homework() {

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
