package org.compain.library.exposition;

import org.compain.library.service.BorrowingMapper;
import org.compain.library.service.BorrowingService;
import org.compain.library.service.DTO.BorrowingDTO;
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

    @GetMapping("/user/{idUser}")
    public List<BorrowingDTO> findAllByUser(@PathVariable("idUser") Long idUser) {
        return borrowingService.findAllByIdUser(idUser);
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

    @PatchMapping("/borrowing-prolongation/{idBorrowing}")
    public ResponseEntity patchRenewal(@PathVariable("idBorrowing") Long idBorrowing) {
        LocalDateTime today = LocalDateTime.now();
        BorrowingDTO borrowingDTO = borrowingService.findByIdBorrowing(idBorrowing);
        if (borrowingDTO.getRenewal() == false && today.isBefore(borrowingDTO.getBorrowingLimitDate().plusWeeks(4))) {
            borrowingDTO.setBorrowingLimitDate(borrowingDTO.getBorrowingLimitDate().plusWeeks(4));
            borrowingDTO.setRenewal(true);
            borrowingService.updateBorrowing(borrowingDTO);
        }
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/borrowing-returned/{idBorrowing}")
    public ResponseEntity patchReturned(@PathVariable("idBorrowing") Long idBorrowing) {
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setIdBorrowing(idBorrowing);
        borrowingDTO.setReturned(true);
        borrowingService.updateBorrowing(borrowingDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("borrowing-new")
    public ResponseEntity<Void> addBorrowing(@RequestBody BorrowingDTO newBorrowingDTO) {
        borrowingService.save(newBorrowingDTO);
        return ResponseEntity.ok().build();
    }
}
