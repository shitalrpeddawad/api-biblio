package org.compain.library.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
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

}
