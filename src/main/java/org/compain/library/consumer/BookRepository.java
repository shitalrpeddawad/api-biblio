package org.compain.library.consumer;

import org.compain.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, IBookRepository {


    @Query(value = "SELECT DISTINCT b.* FROM books b " +
            "INNER JOIN copies ON b.id_book = copies.id_book " +
            "WHERE copies.id_library = :idLibrary",
            nativeQuery = true)
    List<Book> findBookByLibrary(Long idLibrary);

    @Query(value = "SELECT * FROM books b " +
            "INNER JOIN categories c ON b.id_category = c.id_category " +
            "WHERE b.id_book = :idBook",
            nativeQuery = true)
    Book findByIdBook(Long idBook);
}
