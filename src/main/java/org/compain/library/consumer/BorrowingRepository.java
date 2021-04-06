package org.compain.library.consumer;

import org.compain.library.model.Borrowing;
import org.compain.library.model.Copy;
import org.compain.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    List<Borrowing> findAll();
    List<Borrowing> findByCopy(Copy copy);
    List<Borrowing> findByUser(User user);
    Borrowing findByIdBorrowing(Long id);

}
