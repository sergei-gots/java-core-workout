package pro.sky.course_1_basics.hw_12;

import java.util.Objects;

public class Book {
    private String title;
    private final Author author;
    private int year;

    public Book (String title) {
        this(title, new Author("Test-Author First Name", "Test-Author"), 0);
    }
    public Book(String title, Author author, int year) {

        setTitle(title);

        if (author == null) {
            throw new IllegalArgumentException("Author should be defined.");
        }
        this.author = author;

        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  author + ". \"" + title + "\", " + year + '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public void setTitle(String title) {
        Utils.checkName(title);
        this.title = title;
    }
}
