package pro.sky.java.playground;

import  pro.sky.java.course_1_basics.hw_12.Book;

public class L_2_1_Core_EveryThingIsPassedByValue {

    public static void main(String[] args) {
        main_int(args);
        main_Strings(args);
        main_Books(args);
        main_Null(args);
        doNothing();
        concatenateTheSameStringSeveralTimes();
    }

    private static void main_Null(String[] args) {
        String result = null;
        System.out.println("result = " + result);
        Book [] books = {
                new Book("Book-1"),
                null,
                new Book("Book-2")};
        for (Book book: books) {
            if (book != null) {
                System.out.println("book = " + book);
            }
        }
    }

    public static void doSmth(int param) {
        param = 6;
        System.out.println("param = " + param);
    }

    public static void main_int (String[] args) {
        int a = 5;
        System.out.println("a = " + a);
        doSmth(a);
        System.out.println("a = " + a);
    }

    public static void doSmth(String s2) {
        s2 = "bcd";
        System.out.println("s2 = " + s2);
    }

    public static void main_Strings(String[] args) {
        String s = "abc";
        System.out.println("s = " + s);
        doSmth(s);
        System.out.println("s = " + s);
    }

    public static void doSmth(Book b2) {
        b2.setTitle("Book2");
    }

    public static void main_Books(String[] args) {
        Book b = new Book("Book1");
        System.out.println("Book name = " + b.getTitle());
        doSmth(b);
        System.out.println("Book name = " + b.getTitle());
    }

    public static void doNothing() {
        int num = 0;

        for (int i = 0; i < 100; i++) {
            num += i;
        }
    }

    public static void concatenateTheSameStringSeveralTimes() {
        StringBuilder str = new StringBuilder("str");

        for (int i = 0; i < 10; i++) {
            str.append("str");
        }

        System.out.println(str);
    }


}
