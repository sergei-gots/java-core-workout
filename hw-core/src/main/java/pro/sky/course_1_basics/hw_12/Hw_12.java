package pro.sky.course_1_basics.hw_12;

import pro.sky.util.Homework;

import static java.lang.System.out;

public class Hw_12 implements Homework {
    private final Library library = new Library();
    @Override
    public void homework() {
        out.println("HW 1.12. \"Objects and Classes\".");

        Author authorSalinger = new Author("Jerome David", "Salinger");
        Author authorKing = new Author("Stephen", "King");

        library.addBook("The Catcher in the Rye", authorSalinger, 1951);
        library.addBook("Raise High the Roof Beam, Carpenters and Seymour: an Introduction",
                authorSalinger, 1963);
        Book bookShining = library.addBook("The Shining", authorKing, 1976);

        library.printCatalog();

        out.println("\nПодправим год издания у книги " +
                bookShining +
                " - первое издание вышло в свет в 1977 году.");
        bookShining.setYear(1977);

        out.println("\nПопробуем добавить в библиотеку книгу с пустым названием и без автора. " +
                "Посмотрим, на чем споткнёмся:) ");
        try {
            library.addBook("", null, -1);
        } catch (Exception e) {
            out.println(e);
        }

        out.println("\nИтого:");
        library.printCatalog();

        out.println();
    }
}
