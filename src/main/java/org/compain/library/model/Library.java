package org.compain.library.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
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
    @OneToMany (targetEntity= User.class, mappedBy="library", cascade = CascadeType.ALL)
    private List<User> users;

}
