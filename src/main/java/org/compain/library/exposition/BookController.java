package org.compain.library.exposition;

import org.compain.library.security.AuthenticationService;
import org.compain.library.security.ClientToken;
import org.compain.library.security.JwtAuthenticationFilter;
import org.compain.library.service.BookService;
import org.compain.library.service.DTO.AuthenticationDTO;
import org.compain.library.service.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
private AuthenticationService authenticationService;



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
    //@GetMapping("book/{id}")
    //public BookDTO getBook(@PathVariable("id") Long id){
    //    BookDTO bookDTO = bookService.getBook(id);
    //    if (bookDTO == null) throw new EntityNotFoundException(id);
    //    return bookDTO;
    //}

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }

}



