package org.compain.library.consumer;

import org.compain.library.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findAll();
    Role findByIdRole(Integer id);
    Role findByDesignation(String designation);
}
