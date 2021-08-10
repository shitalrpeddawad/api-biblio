package org.compain.library.service;
import org.compain.library.consumer.BookRepository;
import org.compain.library.consumer.CategoryRepository;
import org.compain.library.consumer.CopyRepository;
import org.compain.library.model.Book;
import org.compain.library.service.DTO.BookDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.toList;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    public BookService(BookRepository bookRepository, CopyRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }

    public BookDTO findById(Long idBook, Long idLibrary){
        BookDTO bookDto = BookMapper.toDTO(bookRepository.findByIdBook(idBook));
        bookDto.setNumberOfCopies(copyRepository.countAvailableCopiesNumberByBookAndLibrary(bookDto.getIdBook(), idLibrary));
        return bookDto;
    }

    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::toDTO).collect(toList());
    }

    public List<BookDTO> findAllByLibrary(Long id) {
        List<Book> books = bookRepository.findBookByLibrary(id);
        return books.stream().map(b-> Map.entry(b, copyRepository.countAvailableCopiesNumberByBookAndLibrary(b.getIdBook(),id)))
                .map(BookMapper::toDTO).collect(toList());

    }

    public List<BookDTO> findAllAvailableByLibrary(Long id) {
        List<Book> books = bookRepository.findBookByLibrary(id);
        return books.stream().map(b-> Map.entry(b, copyRepository.countAvailableCopiesNumberByBookAndLibrary(b.getIdBook(),id)))
                .map(BookMapper::toDTO).collect(toList());

    }

    public List<BookDTO> search(String title, String authorName, String categoryName, Long idLibrary) {
        List<Book> books = bookRepository.search(title, authorName, categoryName);
        return books.stream().map(b-> Map.entry(b, copyRepository.countAvailableCopiesNumberByBookAndLibrary(b.getIdBook(),idLibrary)))
                .map(BookMapper::toDTO).collect(toList());
    }

    public void deleteBook(Long idBook){
        bookRepository.deleteById(idBook);
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

}
