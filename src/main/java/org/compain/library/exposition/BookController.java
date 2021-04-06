package org.compain.library.exposition;

import org.compain.library.model.Category;
import org.compain.library.service.BookService;
import org.compain.library.service.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

   // @GetMapping("/title/{bookTitle}")
   // public List<BookDTO> findByTitle(@PathVariable String bookTitle) {
    //    return bookService.findByTitle(bookTitle);
   // }

   // @GetMapping("/author/{bookAuthor}")
   //public List<BookDTO> findByAuthor(@PathVariable String bookAuthor) {
    //    return bookService.findByAuthor(bookAuthor);
    //}

    //@GetMapping("/category/{bookCategory}")
    //public List<BookDTO> findByCategory(@PathVariable String bookCategory) {
    //    return bookService.findByCategory(bookCategory);
   // }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }


}



