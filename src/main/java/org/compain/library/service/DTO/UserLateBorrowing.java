package org.compain.library.service.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserLateBorrowing {

    private String name;
    private String firsname;
    private String email;
    private List<LateBorrowing> lateBorrowingList;

    @Data
    public static class LateBorrowing {
        private String title;
        private String author;
        private LocalDateTime borrowing_limit_date;
    }
}
