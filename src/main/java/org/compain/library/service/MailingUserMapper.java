package org.compain.library.service;

import org.compain.library.service.DTO.BorrowingDTO;
import org.compain.library.service.DTO.MailingUserDTO;

public class MailingUserMapper {

    public static MailingUserDTO toMailingUserDTO(BorrowingDTO borrowingDTO){
        MailingUserDTO mailingUserDTO = new MailingUserDTO();
        mailingUserDTO.setEmailUser(borrowingDTO.getUserDto().getEmail());
        mailingUserDTO.setBook(borrowingDTO.getCopyDto().getBookDto().getTitle());
        mailingUserDTO.setDateLimit(borrowingDTO.getBorrowingLimitDate());
        mailingUserDTO.setName(borrowingDTO.getUserDto().getName());
        mailingUserDTO.setFirstName(borrowingDTO.getUserDto().getFirstname());
        mailingUserDTO.setLibrary(borrowingDTO.getCopyDto().getLibraryDto().getAddress());
        return mailingUserDTO;
    }
}
