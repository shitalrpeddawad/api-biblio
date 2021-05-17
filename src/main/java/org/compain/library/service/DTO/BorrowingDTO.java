package org.compain.library.service.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BorrowingDTO{
    private Long idBorrowing;
    private CopyDTO copyDto;
    private UserDTO userDto;
    private LocalDateTime borrowingDate;
    private LocalDateTime borrowingLimitDate;
    private Boolean renewal;
    private Boolean returned;

}
