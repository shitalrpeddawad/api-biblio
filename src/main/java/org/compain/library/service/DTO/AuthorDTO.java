package org.compain.library.service.DTO;

import org.compain.library.model.Book;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class AuthorDTO {

    private Long idAuthor;
    private String name;
    private String firstname;
    private Date birth;
    private Date death;
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
