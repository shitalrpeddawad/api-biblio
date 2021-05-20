package org.compain.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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

}
