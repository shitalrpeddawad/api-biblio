package org.compain.library.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
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

}
