package org.compain.library.consumer;

import org.compain.library.model.Role;
import org.compain.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    @Query(
            value =  "SELECT * FROM users s " +
                    "WHERE s.email = :email",
            nativeQuery = true
    )
    Optional<User> findByUsername(String email);
    Optional<User> findByIdUser(Long idUser);
}
