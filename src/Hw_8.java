import java.util.Arrays;

public class Hw_8 {
    public static void homework8() {
        System.out.println("Homework 1.8. Arrays");

        boolean isHomework = true;

        if (!isHomework) {
            lesson();
        }

        task1_2_3();
        task4();

    }


    /**
     * Задача 4.
     * Пройдитесь по первому целочисленному массиву и все нечетные числа в нем сделайте четными (нужно прибавить 1).
     * Важно: код должен работать с любым целочисленным массивом, поэтому для решения задания используйте циклы.
     * Распечатайте результат преобразования в консоль.
     */
    private static void task4() {
        System.out.println("Task 4:");

        int[] array1 = new int[3];

        for (int i = 0; i < array1.length; ) {
            array1[i] = ++i;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] % 2 != 0) {
                array1[i] += 1;
            }
        }

        System.out.print("array1 = ");
        System.out.println(Arrays.toString(array1));

        System.out.println();
    }


    /**
     * Задачи 1, 2 и 3.
     * Объявите три массива:
     * - Целочисленный массив, заполненный тремя цифрами — 1, 2 и 3 — с помощью ключевого слова new.
     * - Массив, в котором можно хранить три дробных числа — 1.57, 7.654, 9.986. Массив сразу заполните значениями.
     * - Произвольный массив. Тип и количество данных определите сами.
     * Самостоятельно выберите способ создания массива: с помощью ключевого слова или сразу заполненный элементами.
     * <p>
     * Распечатайте на отдельной строчке элементы каждого массива по порядку через запятую.
     * В конце строки запятую ставить не надо.
     * <p>
     * Задача 3.
     * Распечатайте на отдельной строчке элементы каждого массива в обратном порядке через запятую. В конце строки запятую ставить не надо.
     */
    private static void task1_2_3() {

        System.out.println("Tasks 1, 2:");

        int[] array1 = new int[3];
        double[] array2 = {1.57, 7.654, 9.986};
        double[] myArray = new double[]{Math.E, Math.PI};

        for (int i = 0; i < array1.length; ) {
            array1[i] = ++i;
        }

        System.out.print("array1 = ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]);
            if (i != array1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("array2 = ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + ", ");
            if (i != array2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("myArray = ");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + ", ");
            if (i != myArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");


        System.out.println("Task 3:");
        System.out.print("array1 = ");
        for (int i = array1.length - 1; i >= 0; i--) {
            System.out.print(array1[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("array2 = ");
        for (int i = array2.length - 1; i >= 0; i--) {
            System.out.print(array2[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("myArray = ");
        for (int i = myArray.length - 1; i >= 0; i--) {
            System.out.print(myArray[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println();

    }

    private static void lesson() {
        System.out.println("Lesson 8. Arrays");
        int[] monthsWeights = {90, 91, 93, 92, 85, 87, 88, 89, 0, 0, 0, 0};
        int month = 0;

        monthsWeights[0] = 90;
        System.out.println(monthsWeights[month]);

        for (int i = 0; i < monthsWeights.length; i++) {
            System.out.print(monthsWeights[i] + " ");
        }

        System.out.println("\n");
    }
}