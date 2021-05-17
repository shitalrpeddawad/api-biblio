package org.compain.library.service;

import org.compain.library.consumer.BorrowingRepository;
import org.compain.library.model.Borrowing;
import org.compain.library.service.DTO.BorrowingDTO;
import org.compain.library.service.DTO.MailingUserDTO;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    public List<BorrowingDTO> findAll() {
        List<Borrowing> borrowings = borrowingRepository.findAll();
        return borrowings.stream().map(BorrowingMapper::toDTO).collect(toList());
    }

    public List<BorrowingDTO> findAllByIdUser(Long idUser){
        List<Borrowing> borrowings = borrowingRepository.findByIdUser(idUser);
        return borrowings.stream().map(BorrowingMapper::toDTO).collect(toList());
    }

    public BorrowingDTO findByIdBorrowing(Long idBorrowing){
        return  BorrowingMapper.toDTO(borrowingRepository.findByIdBorrowing(idBorrowing));
    }

    public List<BorrowingDTO> findByDateBefore(LocalDateTime dateTime){
        List<Borrowing> borrowings = borrowingRepository.findByDateBefore(dateTime);
        return borrowings.stream().map(BorrowingMapper::toDTO).collect(toList());
    }

    public void updateBorrowing(BorrowingDTO borrowingPatched){
        Borrowing oldBorrowing =  borrowingRepository.findByIdBorrowing(borrowingPatched.getIdBorrowing());
        borrowingRepository.save(BorrowingMapper.patch(borrowingPatched, oldBorrowing));
    }

    public void save(BorrowingDTO newBorrowingDTO) {
        borrowingRepository.save(BorrowingMapper.toEntity(newBorrowingDTO));
    }
}
