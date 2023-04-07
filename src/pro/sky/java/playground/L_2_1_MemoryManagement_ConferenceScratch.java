package pro.sky.java.playground;

import javax.swing.plaf.basic.BasicArrowButton;
import java.util.*;

import pro.sky.java.util.BasicService;


public class L_2_1_MemoryManagement_ConferenceScratch {
    static int causeStackOverlowErrorCount = 0;
    private static List<Object> objects = new ArrayList<>();
    //It's a FIELD:
    private int a;

    //Method accept REFERENCE-parameter args.
    //It wights as a REFERENCE 8 BYTES and stored in the STACK.
    public static void main(String[] args) {
        System.out.println("Zoom conference assistance.");

        //causeStackOverflowError();
        System.out.println("fibonacci(1) = " + fibonacci(1));
        System.out.println("fibonacci(2) = " + fibonacci(2));
        System.out.println("fibonacci(3) = " + fibonacci(3));
        System.out.println("fibonacci(4) = " + fibonacci(4));
        System.out.println("fibonacci(5) = " + fibonacci(5));
        System.out.println("fibonacci(6) = " + fibonacci(6));
        System.out.println("fibonacci(7) = " + fibonacci(7));

        System.out.println("factorial(0) = " + factorial(0));
        System.out.println("factorial(1) = " + factorial(1));
        System.out.println("factorial(2) = " + factorial(2));
        System.out.println("factorial(3) = " + factorial(3));
        System.out.println("factorial(4) = " + factorial(4));
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("factorial(6) = " + factorial(6));


        //"s" is a local variable of a method "main".
        //It weights as a REFERENCE 8 BYTES and stored in the STACK.
        String s;
        //"o" is a local variable of a method "main".
        //It weights as a REFERENCE 8 BYTES and stored in the STACK.
        //Object  created with an operator "new" (referred with the local variable-reference "o")
        // will be stored in the HEAP.
        Object o = new Object();

        //runs JVM to start GC. But it's not a guarantee that all unused objects will be removed.
        //Actually GC is an undetermined process and practically is not able be predicted.
        //Normally GC has been executing constantly.
        System.gc();


        //"scratch" is a local variable of a method "main".
        //It weights as a REFERENCE 8 BYTES and stored in the STACK.
        //Object(s) created with an operator "new" (referred with the local variable-reference)
        // will be stored in the HEAP.
        L_2_1_MemoryManagement_ConferenceScratch scratch = new L_2_1_MemoryManagement_ConferenceScratch();

        //This "a" is a local variable of a method "main".
        //It weights as an INT 4 BYTES and stored in the STACK.
        int a = 10;
        //This "scratch.a" is a field of an object "scratch"
        scratch.a = 5;

        //Stack trace section (19:10 -
        method1();
        printStackTrace("main");

        doForGCReport();


        Object intValue = 33;
        Object [] intValues = new Object [] { 1, 2} ;
        //- Reference in Java is a reference to an Object
        // - Everything in Java is passed to a method as a parameter BY ITS VALUE.
        // That means, that value from a local variable of called method will be copied
        // into a new variable within calling method.
        System.out.println("intValue = " + intValue);
        System.out.println("Arrays.toString(intValues) = " + Arrays.toString(intValues));
        method(a, intValue, intValues);
        System.out.println("intValue = " + intValue);
        System.out.println("Arrays.toString(intValues) = " + Arrays.toString(intValues));

    }

    //int a will be like a local variable within the method "method" and will take 4 BYTES in Stack.
    //Object o will be like a local reference variable and will take 8 BYTES in Stack.
    //Object [] will be like a local ref.variable and will take the 8 BYTES in Stack.
    private static void method(int a, Object o, Object [] objects) {
        //o will be look at a new object with its value 22.
        o = 22;
        //objects will continue to refer on the objects from the calling method.
        //Here we will change the state of that objects, actually - the first item of its array:
        objects[0] = 99;
    }

    private static int factorial(int n) {
        if (n < 0) {
            throw (new IllegalArgumentException("n could be not less than 1. Your n = " + n));
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    private static int fibonacci(int n) {
        if (n < 1) {
            throw (new IllegalArgumentException("n could be not less than 1. Your n = " + n));
        }
        if (n <= 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void causeStackOverflowError() {
        System.out.println("causeStackOverlowErrorCount = " + ++causeStackOverlowErrorCount);
        causeStackOverflowError();
    }

    private static void doForGCReport() {
        //This will cause OutOfMemoryError:
        //int howMany = 1_000_000_000;
        //This is ok:
        int howMany = 10_000_000;
        for (int i = 0; i < howMany; i++) {
            Object obj = new Object();
            objects.add(obj);
        }

        long count = objects.stream().map(o -> o.hashCode() > 0).count();
        System.out.println(count);
    }

    private static void method1() {
        printStackTrace("method1");
        method2();
    }

    private static void method2() {
        printStackTrace("method2");
        method3();
        method4();
    }

    private static void method3() {
        printStackTrace("method3");
        method4();
    }

    private static void method4() {
        printStackTrace("method4");
        System.out.println("Hello world");
    }

    private static void printStackTrace(String method) {
        BasicService.printHeader("Stack trace called from a method \"" + method + "\":");
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            System.out.println(stackTraceElement);
        }
        BasicService.printFooter();
    }


}
