package org.compain.library.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_category" }) })

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany( targetEntity= Book.class, mappedBy="category", cascade = CascadeType.ALL, fetch= FetchType.EAGER )
    private List<Book> books;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
