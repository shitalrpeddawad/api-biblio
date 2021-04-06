package org.compain.library.consumer;

import org.compain.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepository{


    List<Book> search(String title, String authorName, String categoryName);


    //List<Book> findByTitle(String bookTitle);
    //List<Book> findByAuthor(Author bookAuthor);
    //List<Book> findByCategory(String category);


}
