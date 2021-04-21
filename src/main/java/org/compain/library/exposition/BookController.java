package org.compain.library.exposition;

import org.compain.library.model.Book;
import org.compain.library.model.Category;
import org.compain.library.service.BookService;
import org.compain.library.service.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/library/{idLibrary}")
    public List<BookDTO> findAllByLibrary(@PathVariable("idLibrary") Long idLibrary) {
        return bookService.findAllByLibrary(idLibrary);
    }

    @GetMapping("/book-available-library/{idLibrary}")
    public List<BookDTO> findAvailableByLibrary(@PathVariable("idLibrary") Long idLibrary) {
        return bookService.findAllAvailableByLibrary(idLibrary);
    }

    @GetMapping("search")
    public List<BookDTO> search(@RequestParam (required = false) String title, @RequestParam (required = false) String authorName, @RequestParam (required = false) String categoryName, @RequestParam (required = false) String idBook) {
        return bookService.search(title, authorName, categoryName, idBook);
    }
    @GetMapping("book/{id}")
    public BookDTO getBook(@PathVariable("id") Long id){
        return bookService.getBook(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }



}



