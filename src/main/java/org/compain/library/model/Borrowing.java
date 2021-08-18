package org.compain.library.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Borrowings", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_borrowing" }) })
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrowing")
    private Long idBorrowing;

    @ToString.Exclude
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_copy", referencedColumnName = "id_copy" )
    private Copy copy;

    @ToString.Exclude
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user" )
    private User user;

    @Column(name = "borrowing_date")
    private LocalDateTime borrowingDate;

    @Column(name = "borrowing_limit_date")
    private LocalDateTime borrowingLimitDate;

    @Column(name = "renewal")
    private Boolean renewal;

    @Column(name = "returned")
    private Boolean returned;

}
