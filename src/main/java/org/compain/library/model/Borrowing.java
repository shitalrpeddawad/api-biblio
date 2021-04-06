package org.compain.library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Borrowings", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_borrowing" }) })
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrowing")
    private Long idBorrowing;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_copy", referencedColumnName = "id_copy" )
    private Copy copy;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user" )
    private User user;

    @Column(name = "borrowing_date")
    private Date borrowingDate;

    @Column(name = "renawal")
    private Boolean renawal;

    @Column(name = "returned")
    private Boolean returned;

    public Long getIdBorrowing() {
        return idBorrowing;
    }

    public void setIdBorrowing(Long idBorrowing) {
        this.idBorrowing = idBorrowing;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Boolean getRenawal() {
        return renawal;
    }

    public void setRenawal(Boolean renawal) {
        this.renawal = renawal;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
