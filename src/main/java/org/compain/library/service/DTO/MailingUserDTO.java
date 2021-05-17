package org.compain.library.service.DTO;

import lombok.Data;
import org.compain.library.model.Borrowing;
import org.compain.library.service.CopyMapper;
import org.compain.library.service.MailingUserMapper;
import org.compain.library.service.UserMapper;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MailingUserDTO {

   private String emailUser;
   private String name;
   private String firstName;
   private String book;
   private LocalDateTime dateLimit;
   private String library;

}
