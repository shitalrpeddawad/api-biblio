package org.compain.library.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Books", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_book" }) })

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn( name="id_author" )
    private Author author;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "summary")
    private String summary;

    @ManyToOne
    @JoinColumn( name="id_category" )
    private Category category;

    @OneToMany (targetEntity= Copy.class, mappedBy="book", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Copy> copies;

    public Book() {
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
