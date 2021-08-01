package org.compain.library.exposition;

import org.compain.library.security.ClientToken;
import org.compain.library.service.BorrowingService;
import org.compain.library.service.DTO.BorrowingDTO;
import org.compain.library.service.DTO.InfoBorrowingDTO;
import org.compain.library.service.DTO.UserLateBorrowing;
import org.compain.library.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;
    @Autowired
    private MailService mailService;

    @GetMapping
    public List<BorrowingDTO> findAll() {
        return borrowingService.findAll();
    }

    @GetMapping("/user")
    public List<InfoBorrowingDTO> findAllByUser(ClientToken user) {
        return borrowingService.findAllByIdUser(user.getUserId());
    }

    @GetMapping("/late-borrowing")
    public List<UserLateBorrowing> findBorrowingsPassed() {
        LocalDateTime today = LocalDateTime.now();
        return borrowingService.findLateBorrowing(today);
    }

    @PostMapping("/borrowing-prolongation")
    public void renewalBorrowing(ClientToken user, @RequestBody Long idBorrowing) {
    borrowingService.renewBorrowing(idBorrowing);
    }

    @PostMapping("/borrowing-returned")
    public void returnedBorrowing(ClientToken user, @RequestBody Long idBorrowing) {
        borrowingService.returnBorrowing(idBorrowing);
    }

    @PostMapping("borrowing-new")
    public void addBorrowing(@RequestBody BorrowingDTO newBorrowingDTO) {
        borrowingService.save(newBorrowingDTO);
    }

    @PostMapping("/recovery-late-borrowing")
    public void sendMailForRecoveryLateBorrowing(@RequestBody UserLateBorrowing userLateBorrowing) throws MessagingException {
    mailService.sendMailForLateBorrowing(userLateBorrowing);
    }
}
