public class Main {

    enum HW_NUMBER {
        HW_1,
        HW_2,
        HW_3,
        HW_4,
        HW_5,
        HW_6
    }
    public static void main(String[] args) {

        HW_NUMBER hwNumber = HW_NUMBER.HW_6;

        switch(hwNumber) {
            case HW_1:
                System.out.println("Hello, world!");
                break;
            case HW_2: Hw_2.homework1(); break;
            case HW_3: Hw_3.homework3(); break;
            case HW_4: Hw_4.homework4(); break;
            case HW_5: Hw_5.homework5(); break;
            case HW_6: Hw_6.homework6(); break;

        }
    }
}