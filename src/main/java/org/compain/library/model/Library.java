package org.compain.library.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Libraries", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_library" }) })

public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_library")
    private Long idLibrary;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany( targetEntity= Copy.class, mappedBy="library", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Copy> copies;

    public Long getIdLibrary() {
        return idLibrary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public void setIdLibrary(Long idLibrary) {
        this.idLibrary = idLibrary;
    }
}
