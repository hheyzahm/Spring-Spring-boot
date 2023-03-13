package springFrameworkSpringBoot.domain;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookID;
    private String title;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = @JoinColumn(name = "book_id")
    , inverseJoinColumns = @JoinColumn(name = "author_id"))
   private Set<Author> authors;
    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookID, book.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
