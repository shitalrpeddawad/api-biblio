package org.compain.library.service;


import org.compain.library.consumer.UserRepository;
import org.compain.library.model.User;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String email){
        return userRepository.findByUsername(email);
    }

    public void save(User user) {
        user.getPassword().
    }
}
