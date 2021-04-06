package org.compain.library.consumer;

import org.compain.library.model.Role;
import org.compain.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    List<User> findByRole (Role role);
    User findByIdUser(Long id);
    User findByName(String name);
}
