package pro.sky.java.playground;

public interface InterfaceExample {
    default void f() {
        System.out.println("InterfaceExample.f()");
    }
}
