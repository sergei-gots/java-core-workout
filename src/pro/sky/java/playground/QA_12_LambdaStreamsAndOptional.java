package pro.sky.java.playground;

public class Lambda {

    private int a;
    private static int s;

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        InnerClass innerClass = lambda.new InnerClass();
        NestedClass nestedClass = new NestedClass();

        class LocalClass {
            String s = "Local class is an extremely rare case";
            void f() {
                System.out.println("s = " + s);
            }
        };

        LocalClass localClass = new LocalClass();
        localClass.f();

        Interface  interface1 = new Interface() {

        };



    }

    class InnerClass {
        void f() {
            System.out.println("Lambda.a = " + a);
        }
    }

    static class NestedClass {
        void f() {
            System.out.println("Lambda.s = " + Lambda.s);
        }
    }




}

interface Interface {
    default void f1() {}
    default void f2() {     }

}
class Class1 implements  Interface {
    void f3(){}
    void f4(){}
}


