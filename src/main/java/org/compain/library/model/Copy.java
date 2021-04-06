package org.compain.library.model;

import javax.persistence.*;

@Entity
@Table(name = "Copies", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_copy" }) })

public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_copy")
    private Long idCopy;

    @ManyToOne
    @JoinColumn( name="id_book" )
    private Book book;

    @ManyToOne
    @JoinColumn( name="id_library" )
    private Library library;

    @Column(name = "available")
    private Boolean available;

    public Long getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Long idCopy) {
        this.idCopy = idCopy;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
