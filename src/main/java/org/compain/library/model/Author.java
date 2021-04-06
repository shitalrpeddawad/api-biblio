package org.compain.library.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Authors", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_author" }) })
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Long idAuthor;

    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "death")
    private Date death;

    @OneToMany ( targetEntity= Book.class, mappedBy="author" )
    private List<Book> books;

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
