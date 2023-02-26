public class Main {

    enum HW_NUMBER {
        HW_1,
        HW_2,
        HW_3,
        HW_4,
        HW_5,
        HW_6,
        HW_7,
        HW_8,
        HW_9,
        HW_10
    }
    public static void main(String[] args) {

        HW_NUMBER hwNumber = HW_NUMBER.HW_10;

        switch(hwNumber) {
            case HW_1:
                System.out.println("Hello, world!");
                break;
            case HW_2: Hw_2.homework1(); break;
            case HW_3: Hw_3.homework3(); break;
            case HW_4: Hw_4.homework4(); break;
            case HW_5: Hw_5.homework5(); break;
            case HW_6: Hw_6.homework6(); break;
            case HW_7: Hw_7.homework7(); break;
            case HW_8: Hw_8.homework8(); break;
            case HW_9: Hw_9.homework9(); break;
            case HW_10: Hw_10.homework10(); break;

        }
    }
}