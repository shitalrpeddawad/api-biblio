package org.compain.library.service;

import org.compain.library.model.Book;
import org.compain.library.service.DTO.BookDTO;



public class BookMapper {

 public static BookDTO toDTO(Book book){
     BookDTO bookDto = new BookDTO();
     bookDto.setTitle(book.getTitle());
     bookDto.setAuthorDto(AuthorMapper.toDTO(book.getAuthor()) );
     return bookDto;
 }

    public static Book toEntity(BookDTO bookDto){
        Book book = new Book();
        return book;
    }

}
