public class Main {


    public static void main(String[] args) {

        Homework[] hw = { null,
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
                new Hw_11()};

        int hwNumber = 11;
        hw[hwNumber].homework();
    }
}