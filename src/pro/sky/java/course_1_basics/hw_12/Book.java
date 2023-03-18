package pro.sky.java.course_1_basics.hw_12;

import java.util.Objects;

public class Book {
    private final String title;
    private final Author author;
    private int year;

    public Book(String title, Author author, int year) {

        Utils.checkName(title);
        this.title = title;

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
}
