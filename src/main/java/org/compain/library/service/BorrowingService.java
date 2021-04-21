package org.compain.library.service;

import org.compain.library.consumer.BorrowingRepository;
import org.compain.library.model.Borrowing;
import org.compain.library.service.DTO.BorrowingDTO;
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

    public void renewalBorrowing(Long idBorrowing){

        Borrowing oldBorrowing =  borrowingRepository.findByIdBorrowing(idBorrowing);
        Date today = new Date();
        LocalDateTime borrowingDate = oldBorrowing.getBorrowingDate();
        borrowingDate.plusWeeks(8);


        if(borrowingDate.isAfter(oldBorrowing.getBorrowingLimitDate()) && !oldBorrowing.getReturned()){
        oldBorrowing.setRenewal(true);
        borrowingRepository.save(oldBorrowing);
        }

    }
    public void updateBorrowing(Borrowing borrowing, Long idBorrowing) {
      Borrowing oldBorrowing = borrowingRepository.findByIdBorrowing(idBorrowing);
      oldBorrowing.setReturned(borrowing.getReturned());
     borrowingRepository.save(borrowing);
    }
}
