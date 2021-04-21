package org.compain.library.service;

import org.compain.library.model.Borrowing;
import org.compain.library.service.DTO.BorrowingDTO;

public class BorrowingMapper {

    public static BorrowingDTO toDTO(Borrowing borrowing){
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setBorrowingDate(borrowing.getBorrowingDate());
        borrowingDTO.setUserDto(UserMapper.toDTO(borrowing.getUser()));
        borrowingDTO.setCopyDto(CopyMapper.toDTO(borrowing.getCopy()));
        borrowingDTO.setRenewal(borrowing.getRenewal());
        borrowingDTO.setReturned(borrowing.getReturned());
        borrowingDTO.setIdBorrowing(borrowing.getIdBorrowing());
        return borrowingDTO;
    }

    public static Borrowing toEntity(BorrowingDTO borrowingDTO){
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrowingDate(borrowingDTO.getBorrowingDate());
        borrowing.setUser(UserMapper.toEntity(borrowingDTO.getUserDto()));
        borrowing.setCopy(CopyMapper.toEntity(borrowingDTO.getCopyDto()));
        borrowing.setRenewal(borrowingDTO.getRenewal());
        borrowing.setReturned(borrowingDTO.getReturned());
        borrowing.setIdBorrowing(borrowingDTO.getIdBorrowing());
        return borrowing;
    }
}
