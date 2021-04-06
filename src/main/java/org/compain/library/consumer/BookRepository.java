package org.compain.library.consumer;

import org.compain.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends IBookRepository, JpaRepository<Book,Long>  {
}
