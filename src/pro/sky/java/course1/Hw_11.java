package pro.sky.java.course1;

import pro.sky.java.util.Homework;

import java.time.LocalDate;

public class Hw_11 implements Homework {
    enum OS {
        IOS,
        ANDROID
    }

    /**
     * Задача 3.
     * Задача на расчет дней доставки банковской карты.
     * Код доработан таким образом, что существует метод, который на вход принимает дистанцию
     * и возвращает итоговое количество дней доставки.
     */
    private static void task3() {
        for (int distance = -10; distance < 111; distance += 10) {
            try {
                int time = calculateDeliveryTime(distance);
                printShippingDetails(distance, time);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printShippingDetails(int distance, int days) {
        System.out.print("Дистанция до получателя составляет " + distance + " км. ");
        System.out.print("Доставка займёт "
                + ((days < 2) ? "сутки." : days + " суток.") + '\n') ;
    }

    /**
     * Метод расчёта срока доставки карты на дом.
     * В банке для клиентов организовывается доставка карт на дом.
     * Чтобы известить клиента о том, когда будет доставлена его карта,
     * нужно знать расстояние от офиса до адреса доставки.
     * Правила доставки такие:
     * Доставка в пределах 20 км занимает сутки.
     * Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
     * Доставка в пределах 60 км до 100 км добавляет еще одни сутки.
     * Свыше 100 км доставки нет.
     * То есть с каждым следующим интервалом доставки срок увеличивается на 1 день.
     * <p>
     * Напишите программу, которая выдает сообщение в консоль: "Потребуется дней: " + срок доставки.
     * Объявите целочисленную переменную deliveryDistanceKm = 95, которая содержит дистанцию до клиента.
     */
    private static int calculateDeliveryTime(int deliveryDistanceKm) {

        if (deliveryDistanceKm < 0) {
            throw new IllegalArgumentException("Для дистанции до клиента задано некорректное значение: " + deliveryDistanceKm);
        } else if (deliveryDistanceKm < 20) {
            return 1;
        } else if (deliveryDistanceKm < 60) {
            return 2;
        } else if (deliveryDistanceKm <= 100) {
            return 3;
        }

        throw new IllegalArgumentException("К сожалению, на дистанцию свыше 100 км доставка не предусмотрена.");
    }

    /**
     * Задача 2.
     * Вспомните задание 2 из урока «Условные операторы»,
     * где вы предлагали пользователю облегченную версию приложения.
     * Напишите метод, куда подаются два параметра: тип операционной системы (0 — iOS, 1 — Android)
     * и год выпуска устройства.
     * Если устройство старше текущего года, предложите ему установить облегченную версию.
     * Текущий год можно получить таким способом:
     * <p>
     * int currentYear = LocalDate.now().getYear();
     * <p>
     * Или самим задать значение вручную — ввести в переменную числовое значение.
     * В результате программа должна выводить в консоль сообщение, какую версию приложения (обычную или облегченную)
     * и для какой ОС (Android или iOS) установить пользователю.
     */
    private static void task2() {
        System.out.println("Task 2");
        recommendOStoBeInstalled(OS.ANDROID, 2022);
        recommendOStoBeInstalled(OS.IOS, 2023);
        recommendOStoBeInstalled(OS.ANDROID, LocalDate.now().getYear());
        System.out.println();
    }

    /**
     * В метод подаются два параметра: тип операционной системы (0 — iOS, 1 — Android)
     * * и год выпуска устройства.
     * * Если устройство старше текущего года, предложите ему установить облегченную версию.
     * * Текущий год можно получить таким способом:
     * *
     * *       int currentYear = LocalDate.now().getYear();
     * *
     * * Или самим задать значение вручную — ввести в переменную числовое значение.
     * * В результате программа должна выводить в консоль сообщение, какую версию приложения (обычную или облегченную)
     * * и для какой ОС (Android или iOS) установить пользователю.
     */
    private static void recommendOStoBeInstalled(OS clientOS, int manufactureYear) {

        System.out.print("Установите ");
        if (manufactureYear == LocalDate.now().getYear()) {
            System.out.print("облегчённую ");
        }
        System.out.print("версию приложения для устройства на базе ");
        if (clientOS == OS.IOS) {
            System.out.print("iOS ");
        } else {
            System.out.print("Android ");
        }
        System.out.println(manufactureYear + " года выпуска по ссылке.");
    }

    /**
     * Задача 1.
     * Реализуйте метод, который получает в качестве параметра год, проверяет,
     * является ли он високосным, и выводит результат в консоль.
     */
    private static void task1() {
        System.out.println("Task #1:");
        checkIfYearIsLeap(1976);
        checkIfYearIsLeap(2000);
        checkIfYearIsLeap(2000);
        checkIfYearIsLeap(2023);
        System.out.println();
    }

    /**
     * Метод определяет, является ли год високосным или нет,
     * и выводит соответствующее сообщение:
     * « … год является високосным» или «... год не является високосным».
     * Небольшая справка: високосным является каждый четвертый год, но не является каждый сотый.
     * Также високосным является каждый четырехсотый год.
     */
    private static void checkIfYearIsLeap(int year) {

        System.out.print(year);
        System.out.print(" год");

        if (year % 4 != 0 ||
                !(year % 100 != 0 || year % 400 == 0)) {
            System.out.print(" не");
        }
        System.out.println(" является високосным.");
    }

    @Override
    public void homework() {
        System.out.println("HW 1.11. \"Methods\".");

        task1();
        task2();
        task3();

        System.out.println();
    }

}