package org.compain.library.consumer;

import org.compain.library.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {

    List<Copy> findAll();
    List<Copy> findByBook(Book book);
    List<Copy> findByLibrary(Library library);
    //List<Copy> findLibraryCopiesOfBook(Library library, Book book);
    Copy findByIdCopy(Long id);

}
