package org.compain.library.service.DTO;

import lombok.Data;
import org.compain.library.model.Copy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class LibraryDTO {

    private String address;
    private String email;
    private String phone;

}
