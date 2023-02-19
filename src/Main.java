public class Main {

    enum HW_NUMBER {
        HW_0,
        HW_1,
        HW_2
    }
    public static void main(String[] args) {

        HW_NUMBER hwNumber = HW_NUMBER.HW_2;

        switch(hwNumber) {
            case HW_0:
                System.out.println("Hello, world!");
                break;
            case HW_1: Hw_1.homework1(); break;
            case HW_2: Hw_2.homework2(); break;
        }
    }
}