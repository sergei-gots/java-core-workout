package pro.sky.java.course_2_core;

import pro.sky.java.util.Homework;

import java.util.Arrays;

public class Hw_2_1 implements Homework {

    public static void main(String[] args) {
        Homework hw_2_1 = new Hw_2_1();
        hw_2_1.homework();
    }

    @Override
    public void homework() {
        System.out.println("\nHomework #2.1.\n");

        doTaks5();
        doTaks6();
        doTaks7();
        doTaks8();
        doTaks9();
        doTask10();

    }


    /**
     * ## Задание 5
     * <p>
     * Напишите метод, который изменяет значение переменной типа int.
     * Объявите метод changeValue, который принимает параметр типа int под названием value.
     * Внутри метода с помощью оператора присваивания запишите в параметр значение 22.
     * Во вызывающем методе объявите переменную типа int под названием value и запишите туда значение 33.
     * В следующей строке вызовите метод changeValue и передайте в него эту переменную.
     * <p>
     * **Вопрос**: если распечатать переменную в методе main, то какое у нее будет значение?
     * <p>
     * Поясните почему.
     * *На платформу пришлите ответ на вопрос выше.  Код вашего решения присылать на платформу не нужно.*
     **/
    private void doTaks5() {
        System.out.println("\nTask #5");

        int value = 33;

        System.out.println("Initial value of  \"value\"  = " + value);
        changeValue(value);
        System.out.println("Variable \"value\" within the extrinsic method \"doTask5()\" will save its value = " + value);
        System.out.println("It's because to the method \"changeValue\" there is only value, but not a variable itself is passed.");

    }

    private void changeValue(int value) {
        value = 22;
        System.out.println("Variable \"value\" within the method \"changeValue()\" will have value = " + value);
        System.out.println("It's because there was an assignment statement applied.");
    }

    /**
     * ## Задание 6
     * <p>
     * Метод изменяет значение переменной типа Integer.
     * Объявите метод changeValue, который принимает параметр типа Integer под названием value.
     * Внутри метода с помощью оператора присваивания запишите в параметр значение 22.
     * <p>
     * В вызывающем методе объявите переменную типа Integer под названием value
     * и запишите туда значение 33.
     * В следующей строке вызовите метод changeValue и передайте в него эту переменную.
     * <p>
     * ¿Если распечатать переменную в методе main, то какое у нее будет значение?
     * Поясните почему.
     * Сравните и проанализируйте результаты задач 5 и 6, дайте свою оценку.
     */

    private void doTaks6() {
        System.out.println("\nTask #6");

        Integer value = 33;
        System.out.println("initial value = " + value);
        changeValue(value);
        System.out.println("Value after return from the \"changeValue\"-method = " + value);
        System.out.println("It has the initial value, not affected by assignment within the called method \"changeValue\"");
        System.out.println("And it is because though we pass to the method a reference to the object \"value\"");
        System.out.println("which contains a field of a primitive type int but with applying of assigment statement");
        System.out.println("a new instance of a class Integer will be created.");
    }

    private void changeValue(Integer value) {
        value = 22;
        System.out.println("value.intValue() = " + value.intValue());
        System.out.println("Variable \"value\" within the method \"changeValue()\" will have value = " + value);
        System.out.println("It's because there was an assignment statement applied.");
    }

    /**
     * ## **Задание 7**
     * <p>
     * Напишите метод, который изменяет значение массива типа Integer.
     * Объявите метод changeValue, который принимает параметр массива типа Integer
     * под названием value.
     * Внутри метода с помощью оператора присваивания
     * запишите в параметр новый массив {1,2}.
     * <p>
     * В вызывающем объявите массив типа Integer под названием value
     * и запишите туда значение {3,4}.
     * В следующей строке вызовите метод changeValue и передайте в него этот массив.
     * <p>
     * ¿если распечатать массив в методе main, то какие у него будут значения?
     * <p>
     * Поясните почему.
     */
    private void doTaks7() {
        System.out.println("\nTask #7");

        Integer[] value = {3, 4};
        System.out.println("Initial value  = " + Arrays.toString(value));
        changeValue(value);
        System.out.println("value after return from the changeValue = " + Arrays.toString(value));
        System.out.println("It is not affected by changes within the method, because by the assignment");
        System.out.println("statement in \"changeValue\" will be a new instance of array of Integer-s created");
        System.out.println("And it be another array but not the initial one. And the passed to the method reference");
        System.out.println("will refer to that new array, but as a parameter passed to a method it will be");
        System.out.println("a local variable for the method.");
    }

    private void changeValue(Integer[] value) {
        value = new Integer[]{1, 2};
        System.out.println("value after assignment within changeValue = " + Arrays.toString(value));
    }

    /**## **Задание 8**
     Напишите метод, который изменяет значение массива типа Integer.
     Объявите метод changeValue, который принимает параметр массива типа Integer
     под названием value.
     Внутри метода с помощью оператора присваивания запишите
     в первую ячейку параметра цифру 99.
     В вызывающем методе объявите массив типа Integer под названием value
     и запишите туда значение {3,4}.
     В следующей строке вызовите метод changeValue и передайте в него этот массив.

     ¿Если распечатать массив в вызывающем методе, то какие у него будут значения?

     Поясните почему.
     Сравните и проанализируйте результаты задач 7 и 8 и дайте свою оценку.
     *
     */

    private void doTaks8() {
        System.out.println("\nTask #8");

        Integer[] value = {3, 4};
        System.out.println("Initial value  = " + Arrays.toString(value));
        changeValue2(value);
        System.out.println("value after return from the changeValue = " + Arrays.toString(value));
        System.out.println("It is changed with assignment within the method, because assignment occurred within an");
        System.out.println("array object and changed its internal data (namely an item of the array).");
        System.out.println( " It is an internal change within an object passed as a reference to a method.");
    }

    private void changeValue2(Integer[] value) {
        value[0] = 99;
        System.out.println("value after assignment within changeValue = " + Arrays.toString(value));
    }
    /**
     * ## **Задание 9**
     *
     * Объявите объект класса person с полями name и surname.
     * Переопределите у него метод toString так,
     * чтобы он возвращал строку из name и surname.
     * Объявите метод changePerson, который принимает параметр типа Person под названием person.
     * Внутри метода с помощью оператора присваивания запишите в параметр новый объект типа Person.
     * Присвойте строке name значение Ilya, строке surname— значение Lagutenko.
     *
     * В вызывающем методе объявите переменную типа Person под названием person
     * и запишите новый объект типа Person. Присвойте строке name значение Lyapis,
     * строке surname значение — Trubetskoy.
     *
     * В следующей строке вызовите метод changePerson и передайте в него эту переменную.
     * Если распечатать переменную в методе main, то какое у нее будет значение?
     * Поясните почему.
     */
    private class Person {
        String name;
        String surname;

        @Override
        public String toString() {
            return name + ' ' + surname;
        }
    }
    private void doTaks9() {
        System.out.println("\nTask #9");

        Person person = new Person();
        person.name = "Lyapis";
        person.surname = "Trubetskoy";
        System.out.println("Initial person  = " + person);
        changePerson(person);
        System.out.println("Person after return from the changePerson = " + person);
        System.out.println("It is not affected by changes within the method, because with the assignment");
        System.out.println("a new person to the person within the method \"changePerson\" this assignment will");
        System.out.println("assign a reference to a new object created with the operator \"new\" and this reference");
        System.out.println("be assigned to a method parameter variable which is local for the method.");
    }

    private void changePerson(Person person) {
        person = new Person();
        person.name = "Ilya";
        person.surname = "Lagutenko";
        System.out.println("Person after assignments within changePerson = " + person);
    }
    /**
     * ## **Задание 10**
     *
     * Объявите объект класса person с полями name и surname.
     * Переопределите у него метод toString так,
     * чтобы он возвращал строку из name и surname.
     * Объявите метод changePerson, который принимает параметр типа Person под названием person.
     * Внутри метода запишите в поле name строку “Ilya”, а в строку surname — “Lagutenko”.
     *
     * В вызывающем методе объявите переменную типа Person под названием person
     * и запишите новый объект типа Person. Присвойте строке name значение Lyapis,
     * строке surname значение — Trubetskoy.
     *
     * В следующей строке вызовите метод changePerson и передайте в него эту переменную.
     * Если распечатать переменную в методе main, то какое у нее будет значение?
     * Поясните почему.
     */
    private void doTask10() {
        System.out.println("\nTask #10");

        Person person = new Person();
        person.name = "Lyapis";
        person.surname = "Trubetskoy";
        System.out.println("Initial person  = " + person);
        changePerson2(person);
        System.out.println("Person after return from the changePerson = " + person + "!:)");
        System.out.println("It is changed, because we pass to the method a reference to the created person");
        System.out.println("and within the method \"changePerson\" we work on fields of the Person-instance");
        System.out.println("accessible with the passed instance that means the namely that instance we created initially.");
    }

    private void changePerson2(Person person) {
        person.name = "Ilya";
        person.surname = "Lagutenko";
        System.out.println("Person after assignments within changePerson = " + person);
    }


}