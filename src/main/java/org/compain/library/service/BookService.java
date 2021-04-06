package org.compain.library.service;
import org.compain.library.consumer.BookRepository;
import org.compain.library.model.Book;
import org.compain.library.service.DTO.BookDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


import static java.util.stream.Collectors.toList;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::toDTO).collect(toList());
    }

    //public List<BookDTO> findByTitle(String bookTitle) {
     //   List<Book> books = bookRepository.findByTitle(bookTitle);
     //   return books.stream().map(BookMapper::toDTO).collect(toList());
    //}

    //public List<BookDTO> findByCategory(String category){
    //    List<Book> books = bookRepository.findByCategory(category);
     //   return books.stream().map(BookMapper::toDTO).collect(toList());
    //}

    //public List<BookDTO> findByAuthor(String author){
    //    List<Book> books = bookRepository.findByAuthor(author);
    //    return books.stream().map(BookMapper::toDTO).collect(toList());
   // }
    public BookDTO findById(Long idBook){
       Optional<Book> book = bookRepository.findById(idBook);
        return book.map(BookMapper::toDTO).orElse(null);
    }
}
