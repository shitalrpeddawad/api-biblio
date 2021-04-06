package org.compain.library.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Roles", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_role" }) })
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "designation")
    private String designation;

    @OneToMany ( targetEntity= User.class, mappedBy="role", cascade = CascadeType.ALL, fetch= FetchType.EAGER )
    private List<User> users;

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
