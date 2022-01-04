package org.compain.library.service.DTO;

import lombok.Data;

@Data
public class CopyDTO {
    private Long idCopy;
    private BookDTO bookDto;
    private LibraryDTO libraryDto;
    private Boolean available;
}
