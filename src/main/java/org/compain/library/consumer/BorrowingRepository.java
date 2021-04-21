package org.compain.library.consumer;

import org.compain.library.model.Book;
import org.compain.library.model.Borrowing;
import org.compain.library.model.Copy;
import org.compain.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {


    @Query(
            value =  "SELECT * FROM borrowings s " +
                    "WHERE s.id_user = :idUser",
            nativeQuery = true
    )
    List<Borrowing> findByIdUser(Long idUser);
    Borrowing findByIdBorrowing(Long idBorrowing);


}
