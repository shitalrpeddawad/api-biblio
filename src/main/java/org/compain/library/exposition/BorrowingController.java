package org.compain.library.exposition;

import org.compain.library.model.Borrowing;
import org.compain.library.service.BorrowingService;
import org.compain.library.service.DTO.BorrowingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PatchMapping("/borrowing-renewal/{idBorrowing}")
    public void renewalBorrowing(@PathVariable Long idBorrowing){
        borrowingService.renewalBorrowing(idBorrowing);
    }

}
