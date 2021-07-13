package org.compain.library.exposition;

import org.compain.library.model.Borrowing;
import org.compain.library.security.ClientToken;
import org.compain.library.service.BorrowingMapper;
import org.compain.library.service.BorrowingService;
import org.compain.library.service.DTO.BorrowingDTO;
import org.compain.library.service.DTO.InfoBorrowingDTO;
import org.compain.library.service.DTO.MailingUserDTO;
import org.compain.library.service.MailingUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public List<BorrowingDTO> findAll() {
        return borrowingService.findAll();
    }

    @GetMapping("/user")
    public List<InfoBorrowingDTO> findAllByUser(ClientToken user) {
        return borrowingService.findAllByIdUser(user.getUserId());
    }

    @GetMapping("/batch")
    public List<MailingUserDTO> findBorrowingsPassed(){
        LocalDateTime today = LocalDateTime.now();
        List<MailingUserDTO> mailingUserDTOList = new ArrayList<>();
        List<BorrowingDTO> borrowingDTOList = borrowingService.findByDateBefore(today);
        for (BorrowingDTO b : borrowingDTOList)
              {
                  if(b.getReturned() == false ){
                      mailingUserDTOList.add(MailingUserMapper.toMailingUserDTO(b));
                  }
        }
    return mailingUserDTOList ;
    }

    @PostMapping("/borrowing-prolongation")
    public void patchRenewal(ClientToken user, @RequestBody Long idBorrowing){
        LocalDateTime today = LocalDateTime.now();
        BorrowingDTO borrowingDTO = borrowingService.findByIdBorrowing(idBorrowing);
        if (borrowingDTO.getRenewal() == false && today.isBefore(borrowingDTO.getBorrowingLimitDate().plusWeeks(4))) {
            borrowingDTO.setBorrowingLimitDate(borrowingDTO.getBorrowingLimitDate().plusWeeks(4));
            borrowingDTO.setRenewal(true);
            borrowingService.updateBorrowing(borrowingDTO);
        }
    }

    @PatchMapping("/borrowing-returned")
    public void patchReturned(ClientToken user, @RequestBody Long idBorrowing) {
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setIdBorrowing(idBorrowing);
        borrowingDTO.setReturned(true);
        borrowingService.updateBorrowing(borrowingDTO);
    }

    @PostMapping("borrowing-new")
    public ResponseEntity<Void> addBorrowing(@RequestBody BorrowingDTO newBorrowingDTO) {
        borrowingService.save(newBorrowingDTO);
        return ResponseEntity.ok().build();
    }
}
