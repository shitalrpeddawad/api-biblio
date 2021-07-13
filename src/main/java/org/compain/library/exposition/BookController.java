package org.compain.library.exposition;

import org.compain.library.consumer.UserRepository;
import org.compain.library.security.AuthenticationService;
import org.compain.library.security.ClientToken;
import org.compain.library.security.JwtAuthenticationFilter;
import org.compain.library.service.BookService;
import org.compain.library.service.DTO.AuthenticationDTO;
import org.compain.library.service.DTO.BookDTO;
import org.compain.library.service.UserService;
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
    private UserService userService;


    @GetMapping
    public List<BookDTO> findAll(ClientToken user) {
        return bookService.findAllByLibrary(userService.findByIdUser(user.getUserId()).get().getLibrary().getIdLibrary());
    }

    @GetMapping("/book")
    public BookDTO findBookById(ClientToken user,Long idBook) {
        return bookService.findById(idBook);
    }

    @GetMapping("/search")
    public List<BookDTO> search(@RequestParam (required = false) String title, @RequestParam (required = false) String authorName, @RequestParam (required = false) String category) {
        return bookService.search(title, authorName, category);
    }

    @DeleteMapping("delete")
    public void deleteBook(ClientToken user, Long idBook){
        bookService.deleteBook(idBook);
    }

}



