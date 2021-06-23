package org.compain.library.service.DTO;

import lombok.Data;
import org.compain.library.model.Role;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class UserDTO {

    private String name;
    private String firstname;
    private String email;
    private String password;

}
