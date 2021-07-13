package org.compain.library.service.DTO;

import lombok.Data;
import org.compain.library.model.Category;
import java.util.Date;
import java.util.List;
@Data
public class BookDTO {
    private Long idBook;
    private String title;
    private AuthorDTO authorDto;
    private Date publicationDate;
    private String summary;
    private CategoryDTO categoryDto;
    private List<CopyDTO> copiesDto;
    private int numberOfCopies;
}