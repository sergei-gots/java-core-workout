package pro.sky.java.playground;

public class L_2_5_Exceptions {
    public static void main(String[] args) {
        method3();
    }

    public static void method() {

        throw new RuntimeException();
    }

    public static void method1() throws Throwable{

        throw new Exception();


    }

    public static void method2() {

        Error error = new Error();
        throw error;
    }

    public static void method3() {
        //DO NOT CATCH NPE because NPE is just a programmer's mistake.
        //DO NOT THROW NPE - THROW IAE
        //Let a program FAIL FAST.
        Object obj = null;
        System.out.println(obj.toString());
    }


}