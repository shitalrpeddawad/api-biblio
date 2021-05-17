package org.compain.library.service.DTO;

import lombok.Data;
import org.compain.library.model.Book;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
public class AuthorDTO {

    private Long idAuthor;
    private String name;
    private String firstname;
    private Date birth;
    private Date death;

}
