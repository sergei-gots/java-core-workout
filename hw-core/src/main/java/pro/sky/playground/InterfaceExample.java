package pro.sky.playground;

public interface InterfaceExample {
    default void f() {
        System.out.println("InterfaceExample.f()");
    }
}
