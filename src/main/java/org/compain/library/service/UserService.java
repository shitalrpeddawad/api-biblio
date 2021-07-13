package org.compain.library.service;


import org.compain.library.consumer.RoleRepository;
import org.compain.library.consumer.UserRepository;
import org.compain.library.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Optional<User> findByUsername(String email){
        return userRepository.findByUsername(email);
    }

    public Optional<User> findByIdUser(Long idUser){
        return userRepository.findByIdUser(idUser);
    }

    public void save(User user) {
       String password = passwordEncoder.encode(user.getPassword());
       user.setPassword(password);
       userRepository.save(user);
       user.setRole(roleRepository.findByIdRole(2));
    }
}
