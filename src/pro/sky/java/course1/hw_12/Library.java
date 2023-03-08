package pro.sky.java.course1.hw_12;

public class Library {
    private static final int CAPACITY = 10;
    private final Book [] books = new Book[CAPACITY];
    private int booksCount = 0;

    public Book addBook (String title, Author author, int year) {

        if(booksCount == CAPACITY) {
            throw new RuntimeException("Library catalog exhausted (size = " + CAPACITY);
        }

        Book book = new Book(title, author, year);
        books[booksCount++] = book;
        return book;

    }

    public void printCatalog() {
        System.out.println("\nВ нашей библиотеке " + booksCount + " книги: ");
        for (int i = 0; i < booksCount; i++) {
            System.out.println(books[i]);
        }
    }
}
