package org.compain.library.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_user" }) })

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

}