package pro.sky.playground;

class Proto {
    Proto() {
        System.out.println("Constructor of Proto");
    }

    Proto(int x) {
        System.out.println("Constructor of Proto with x=" + x);
    }
    final void x() {
        System.out.println("final method");
    }
}
public class Exam_2 extends Proto{


    static {
        System.out.println("Start static method of the class Exam_2");
    }

    {
        System.out.println("This is pre-method called when object of the class Exam_2 is being creating");
    }

    Exam_2() {
        System.out.println("Constructor of Exam_2");
    }

    Exam_2(int i) {
        super(i);
        System.out.println("Constructor of Exam_2 with i =" + i);
    }

    final public static void main(String[] args) {
        System.out.println("Hello world from Exam_2");
        Exam_2 exam2_1 = new Exam_2();
        Exam_2 exam2_2 = new Exam_2(2);
    }
}
