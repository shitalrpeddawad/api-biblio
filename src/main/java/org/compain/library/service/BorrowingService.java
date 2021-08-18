package org.compain.library.service;

import org.compain.library.consumer.BorrowingRepository;
import org.compain.library.consumer.CopyRepository;
import org.compain.library.consumer.UserRepository;
import org.compain.library.model.Borrowing;
import org.compain.library.model.Copy;
import org.compain.library.model.User;
import org.compain.library.service.DTO.BorrowingDTO;
import org.compain.library.service.DTO.InfoBorrowingDTO;
import org.compain.library.service.DTO.UserLateBorrowing;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final UserRepository userRepository;
    private final CopyRepository copyRepository;

    public BorrowingService(BorrowingRepository borrowingRepository, UserRepository userRepository, CopyRepository copyRepository) {
        this.borrowingRepository = borrowingRepository;
        this.userRepository = userRepository;
        this.copyRepository = copyRepository;
    }

    public List<BorrowingDTO> findAll() {
        List<Borrowing> borrowings = borrowingRepository.findAll();
        return borrowings.stream().map(BorrowingMapper::toDTO).collect(toList());
    }

    public List<InfoBorrowingDTO> findAllByIdUser(Long idUser) {
        List<Borrowing> borrowings = borrowingRepository.findByIdUser(idUser);
        return borrowings.stream().map(BorrowingMapper::infoBorrowingDTO).collect(toList());
    }

    public BorrowingDTO findByIdBorrowing(Long idBorrowing) {
        return BorrowingMapper.toDTO(borrowingRepository.findByIdBorrowing(idBorrowing));
    }

    public List<UserLateBorrowing> findLateBorrowing(LocalDateTime dateTime) {
        List<Borrowing> borrowings = borrowingRepository.findLateBorrowing(dateTime);
        Map<User, List<Borrowing>> collect = borrowings.stream().collect(Collectors.groupingBy(Borrowing::getUser));
        return collect.entrySet().stream().map(BorrowingMapper::toUserLateBorrowing).collect(Collectors.toList());
    }

    public void updateBorrowing(BorrowingDTO borrowingPatched) {
        Borrowing oldBorrowing = borrowingRepository.findByIdBorrowing(borrowingPatched.getIdBorrowing());
        borrowingRepository.save(BorrowingMapper.patch(borrowingPatched, oldBorrowing));
    }

    public void save(BorrowingDTO newBorrowingDTO) {
        Optional<User> user = userRepository.findByUsername(newBorrowingDTO.getUserDto().getEmail());
        Optional<Copy> copy = copyRepository.findById(newBorrowingDTO.getCopyDto().getIdCopy());
        if (user.isPresent() && copy.isPresent()) {
            borrowingRepository.save(BorrowingMapper.toEntity(newBorrowingDTO, user.get(), copy.get()));
        }
    }

    public void renewBorrowing(long idBorrowing) {
        LocalDateTime today = LocalDateTime.now();
        Borrowing borrowing = borrowingRepository.findByIdBorrowing(idBorrowing);
        if (!borrowing.getRenewal() && today.isBefore(borrowing.getBorrowingLimitDate().plusWeeks(4))) {
            borrowing.setBorrowingLimitDate(borrowing.getBorrowingLimitDate().plusWeeks(4));
            borrowing.setRenewal(true);
            borrowingRepository.save(borrowing);
        }
    }

    public void returnBorrowing(Long idBorrowing) {
        Borrowing borrowing = borrowingRepository.findByIdBorrowing(idBorrowing);
        borrowing.setReturned(true);
        borrowingRepository.save(borrowing);
    }
}
