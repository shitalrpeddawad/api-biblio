package org.compain.library.service;

import org.compain.library.model.User;
import org.compain.library.service.DTO.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setFirstname(userDTO.getFirstname());
        return user;
    }
}