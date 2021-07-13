package org.compain.library.service.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InfoBorrowingDTO {

    private Long idBorrowing;
    private String title;
    private String author;
    private LocalDateTime borrowingDate;
    private LocalDateTime borrowingLimitDate;
    private Boolean renewal;
    private Boolean returned;

}
