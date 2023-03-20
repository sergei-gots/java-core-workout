package pro.sky.java.course_2_core;

import pro.sky.java.util.Homework;

public class Hw_2_1 implements Homework {

    public static void main(String[] args) {
        Homework hw_2_1 = new Hw_2_1();
        hw_2_1.homework();
    }
    @Override
    public void homework() {
        System.out.println("\nHomework #2.1.\n");

        doTaks5();
    }


    /**
     * ## Задание 5
     *
     * Напишите метод, который изменяет значение переменной типа int.
     * Объявите метод changeValue, который принимает параметр типа int под названием value.
     * Внутри метода с помощью оператора присваивания запишите в параметр значение 22.
     * Во вызывающем методе объявите переменную типа int под названием value и запишите туда значение 33.
     * В следующей строке вызовите метод changeValue и передайте в него эту переменную.
     *
     *  **Вопрос**: если распечатать переменную в методе main, то какое у нее будет значение?
     *
     * Поясните почему.
     * *На платформу пришлите ответ на вопрос выше.  Код вашего решения присылать на платформу не нужно.*
     *
     **/
    private void doTaks5() {

        int value = 33;

        changeValue(value);
        System.out.println("Variable \"value\" within the extrinsic method \"doTask5()\" will save its value = " + value);
        System.out.println("It's because to the method \"changeValue\" there is only value, but not a variable itself is passed.");

    }

    private void changeValue(int value) {
        value = 22;
        System.out.println("Variable \"value\" within the method \"changeValue()\" will have value = " + value);
        System.out.println("It's because there was an assignment statement applied.");
    }

}
