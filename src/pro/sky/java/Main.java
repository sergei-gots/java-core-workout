package pro.sky.java;

import pro.sky.java.course_1.*;
import pro.sky.java.course_1.hw_12.Hw_12;
import pro.sky.java.util.Homework;

public class Main {


    public static void main(String[] args) {

        Homework[] hw = {null,
                new Homework() {
                    @Override
                    public void homework() {
                        System.out.println("Hello, world!");
                    }
                },
                new Hw_2(),
                new Hw_3(),
                new Hw_4(),
                new Hw_5(),
                new Hw_6(),
                new Hw_7(),
                new Hw_8(),
                new Hw_9(),
                new Hw_10(),
                new Hw_11(),
                new Hw_12()
        };

        int hwNumber = 12;
        hw[hwNumber].homework();
    }
}