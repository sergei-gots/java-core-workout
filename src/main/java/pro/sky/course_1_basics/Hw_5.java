package pro.sky.course_1_basics;

import pro.sky.util.Homework;

public class Hw_5 implements Homework {

    public void homework() {

        System.out.println("Homework #1.5\n");

        task1();
        task2();
        task3();
        task4();
        task5();

        System.out.println();
    }

    /* Задача 5
        Напишите программу, которая определяет по номеру месяца в году,
        к какому сезону этот месяц принадлежит. Например, 1-й месяц (он же январь) принадлежит к сезону зима.
        Для написания программы используйте оператор switch.
        Для обозначения номера месяца используйте переменную monthNumber = 12.
        Пропишите условие, при котором программа не будет выполняться (номер месяца больше 13).
     */
    private static void task5() {
        System.out.println("Task 5");

        byte monthNumber = 6;

        if (monthNumber < 0 || monthNumber > 12) {
            System.out.println("The number " + monthNumber + " is not a number of month.");
        } else {
            System.out.print("The number of month is " + monthNumber + ". And this is ");
            switch (monthNumber) {
                case 12:
                case 1:
                case 2:
                    System.out.print("a winter");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.print("a spring");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.print("a summer");
                    break;
                default:
                    System.out.print("an autumn");
            }
            System.out.println(" month.");
        }
        System.out.println();
    }

    /* Задача 4
            В банке для клиентов организовывается доставка карт на дом.
            Чтобы известить клиента о том, когда будет доставлена его карта,
            нужно знать расстояние от офиса до адреса доставки.
        Правила доставки такие:
            Доставка в пределах 20 км занимает сутки.
            Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
            Доставка в пределах 60 км до 100 км добавляет еще одни сутки.
            Свыше 100 км доставки нет.
        То есть с каждым следующим интервалом доставки срок увеличивается на 1 день.

        Напишите программу, которая выдает сообщение в консоль: "Потребуется дней: " + срок доставки.
        Объявите целочисленную переменную deliveryDistance = 95, которая содержит дистанцию до клиента.
     */
    private static void task4() {
        System.out.println("Task 4");

        short deliveryDistance = 95;

        System.out.println("Дистанция до получателя составляет " + deliveryDistance + " км.");
        if (deliveryDistance < 0) {
            System.out.println("Для дистанции до клиента задано некорректное значение.");
        } else if (deliveryDistance > 100) {
            System.out.println("К сожалению, на дистанцию свыше 100 км доставка не предусмотрена.");
        } else if (deliveryDistance < 20) {
            System.out.println("Доставка (в пределах 20 км) занимает сутки.");
        } else if (deliveryDistance < 60) {
            System.out.println("Доставка (в пределах от 20 км до 60 км) займёт двое суток.");
        } else if (deliveryDistance <= 100) {       //:)
            System.out.println("Доставка (в пределах 60 км до 100 км включительно) займёт трое суток.");
        }

        System.out.println();
    }

    /* Задача 3
        Напишите программу, которая определяет, является ли год високосным или нет.
        Переменную года назовите year, в которую можно подставить значение интересующего нас года.
        Например, 2021.
        Программа должна определять, високосный год или нет, и выводить соответствующее сообщение:
         « …. год является високосным» или «... год не является високосным».
        Небольшая справка: високосным является каждый четвертый год, но не является каждый сотый.
        Также високосным является каждый четырехсотый год.
     */
    private static void task3() {
        System.out.println("Task 3");
        short year = 1976;
        System.out.print(year);
        System.out.print(" год");

        if (year % 4 != 0 ||
                !(year % 100 != 0 || year % 400 == 0)) {
            System.out.print(" не");
        }
        System.out.println(" является високосным.");
    }

    /* Задача 2
        Усложним предыдущую задачу. Теперь нам нужно знать не только операционную систему телефона,
        но и год его создания.
            Ваша задача — написать программу, которая выдает соответствующее сообщение клиенту при наличии
            двух условий.

        Если год выпуска ранее 2015 года, то к сообщению об установке нужно добавить информацию
        об облегченной версии:

            Для iOS оно будет звучать так: «Установите облегченную версию приложения для iOS по ссылке».
            Для Android: «Установите облегченную версию приложения для Android по ссылке».
            Для пользователей телефонов 2015 года выпуска и позже нужно вывести обычное
            предложение об установке приложения.
            Для года создания телефона используйте переменную clientDeviceYear,
            в которой необходимо указать 2015 год.
            Важно: вложенность больше двух этажей не допускается (условный оператор внутри условного оператора).
    */
    private static void task2() {
        System.out.println("Task 2");

        OS clientOS = OS.ANDROID;
        short clientDeviceYear = 2013;

        System.out.print("Установите ");
        if (clientDeviceYear < 2015) {
            System.out.print("облегчённую ");
        }
        System.out.print("версию приложения для ");
        if (clientOS == OS.IOS) {
            System.out.println("iOS по ссылке.");
        } else {
            System.out.println("Android по ссылке.");
        }

        System.out.println();

    }


    /* Задача 1
        У банка появилось мобильное приложение. Поэтому теперь, когда пользователь заходит на сайт с телефона,
        ему предлагается скачать приложение с учетом того, какая операционная система у пользователя.
        Напишите программу, которая определяет, чем пользуется клиент (iOS или Android),
        и выдает соответствующее сообщение:
            Для iOS — «Установите версию приложения для iOS по ссылке».
            Для Android — «Установите версию приложения для Android по ссылке».
        Объявите переменную clientOS, которая равна 0 или 1 (0 — iOS, 1 — Android).
     */
    //local enums are supported since JDK 16
    enum OS {
        IOS,
        ANDROID
    };

    private static void task1() {
        System.out.println("Task 1");

        OS clientOS = OS.IOS;

        if (clientOS == OS.IOS) {
            System.out.println("Установите версию приложения для iOS по ссылке.");
        } else {
            System.out.println("Установите версию приложения для Android по ссылке.");
        }

        System.out.println();
    }
}
