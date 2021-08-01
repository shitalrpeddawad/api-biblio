package org.compain.library.service;

import org.compain.library.model.Borrowing;
import org.compain.library.model.User;
import org.compain.library.service.DTO.UserLateBorrowing;
import org.compain.library.service.DTO.BorrowingDTO;
import org.compain.library.service.DTO.InfoBorrowingDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BorrowingMapper {

    public static InfoBorrowingDTO infoBorrowingDTO(Borrowing borrowing){
        InfoBorrowingDTO infoBorrowingDTO = new InfoBorrowingDTO();
        infoBorrowingDTO.setIdBorrowing(borrowing.getIdBorrowing());
        infoBorrowingDTO.setTitle(borrowing.getCopy().getBook().getTitle());
        infoBorrowingDTO.setBorrowingDate(borrowing.getBorrowingDate());
        infoBorrowingDTO.setBorrowingLimitDate(borrowing.getBorrowingLimitDate());
        infoBorrowingDTO.setRenewal(borrowing.getRenewal());
        infoBorrowingDTO.setReturned(borrowing.getReturned());
        infoBorrowingDTO.setAuthor(borrowing.getCopy().getBook().getAuthor().getFirstname() + " " + borrowing.getCopy().getBook().getAuthor().getName());
        return infoBorrowingDTO;
    }

    public static BorrowingDTO toDTO(Borrowing borrowing){
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setBorrowingDate(borrowing.getBorrowingDate());
        borrowingDTO.setUserDto(UserMapper.toDTO(borrowing.getUser()));
        borrowingDTO.setCopyDto(CopyMapper.toDTO(borrowing.getCopy()));
        borrowingDTO.setRenewal(borrowing.getRenewal());
        borrowingDTO.setReturned(borrowing.getReturned());
        borrowingDTO.setIdBorrowing(borrowing.getIdBorrowing());
        borrowingDTO.setBorrowingLimitDate(borrowing.getBorrowingLimitDate());
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
        borrowing.setBorrowingLimitDate(borrowingDTO.getBorrowingLimitDate());
        return borrowing;
    }

    public static Borrowing patch(BorrowingDTO borrowingDTO, Borrowing borrowing){
        if(borrowingDTO.getRenewal() != null) {
            borrowing.setRenewal(borrowingDTO.getRenewal());
        }
        if(borrowingDTO.getBorrowingDate() != null) {
            borrowing.setBorrowingDate(borrowingDTO.getBorrowingDate());
        }
        if(borrowingDTO.getReturned() != null) {
            borrowing.setReturned(borrowingDTO.getReturned());
        }
        if(borrowingDTO.getBorrowingLimitDate() != null) {
            borrowing.setBorrowingLimitDate(borrowingDTO.getBorrowingLimitDate());
        }
        return  borrowing;
    }

    public static UserLateBorrowing toUserLateBorrowing(Map.Entry<User, List<Borrowing>> entry){
        UserLateBorrowing userLateBorrowing = new UserLateBorrowing();
        userLateBorrowing.setEmail(entry.getKey().getEmail());
        userLateBorrowing.setFirstname(entry.getKey().getFirstname());
        userLateBorrowing.setName(entry.getKey().getName());
        List<UserLateBorrowing.LateBorrowing> collect = entry.getValue().stream().map(b -> {
            UserLateBorrowing.LateBorrowing lateBorrowing = new UserLateBorrowing.LateBorrowing();
            lateBorrowing.setBorrowing_limit_date(b.getBorrowingLimitDate());
            lateBorrowing.setAuthor(b.getCopy().getBook().getAuthor().getFirstname() + " " + b.getCopy().getBook().getAuthor().getName());
            lateBorrowing.setTitle(b.getCopy().getBook().getTitle());
            return lateBorrowing;
        }).collect(Collectors.toList());
        userLateBorrowing.setLateBorrowingList(collect);
        return userLateBorrowing;
    }
}
