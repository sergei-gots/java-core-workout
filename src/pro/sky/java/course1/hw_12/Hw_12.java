package pro.sky.java.course1.hw_12;

import pro.sky.java.util.Homework;

public class Hw_12 implements Homework {


    @Override
    public void homework() {
        System.out.println("HW 1.12. \"Objects and Classes\".");

        Author authorSalinger = new Author("Jerome David", "Salinger");
        Author authorKing = new Author("Stephen", "King");

        Book bookCatcher = new Book("The Catcher in the Rye", authorSalinger, 1951);
        Book bookRaiseHigh = new Book("Raise High the Roof Beam, Carpenters and Seymour: an Introduction",
                authorSalinger, 1963);
        Book bookShining = new Book("The Shining", authorKing, 1976);

        printLibrary(bookCatcher, bookRaiseHigh, bookShining);

        System.out.println("\nПодправим год издания у книги " +
                bookShining +
                " - первое издание вышло в свет в 1977 году.");
        bookShining.setYear(1977);

        System.out.println("\nПопробуем создать книгу с пустым названием и без автора. Посмотрим, на чем споткнёмся:) ");
        try {
            Book book = new Book("", null, -1);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nИтого:");
        printLibrary(bookCatcher, bookRaiseHigh, bookShining);

        System.out.println();
    }

    private void printLibrary(Book... books) {
        System.out.println("\nВ нашей библиотеке " + books.length + " книги: ");
        for (Book book : books) {
            System.out.println(book);
        }

    }

    private void createLibrary() {

    }

}
