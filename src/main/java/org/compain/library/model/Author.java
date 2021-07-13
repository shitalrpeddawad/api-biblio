package org.compain.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
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

    @OneToMany ( targetEntity= Book.class, mappedBy="author", cascade = CascadeType.ALL, fetch= FetchType.EAGER )
    private List<Book> books;

}
