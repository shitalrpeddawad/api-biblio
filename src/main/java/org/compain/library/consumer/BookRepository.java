package org.compain.library.consumer;

import org.compain.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, IBookRepository  {


    @Query(
            value = "SELECT s FROM Book s "
                    + "LEFT JOIN FETCH s.copies copy "
                    + "WHERE s.idBook= :idBook "
    )
    Book getBook(Long idBook);

    @Query(
    value =  "SELECT DISTINCT b.* FROM books b " +
            "INNER JOIN copies ON b.id_book = copies.id_book " +
            "WHERE copies.id_library = :idLibrary",
            nativeQuery = true
    )

    List<Book> findBookByLibrary(Long idLibrary);



}
