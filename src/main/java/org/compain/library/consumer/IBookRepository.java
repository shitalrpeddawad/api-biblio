package org.compain.library.consumer;

import org.compain.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {

    List<Book> search(String title, String authorName, String categoryName);

}
