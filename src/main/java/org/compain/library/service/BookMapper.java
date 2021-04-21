package org.compain.library.service;

import org.compain.library.model.Book;
import org.compain.library.model.Copy;
import org.compain.library.service.DTO.BookDTO;
import org.compain.library.service.DTO.CategoryDTO;

import java.util.Map;


public class BookMapper {

    public static BookDTO toDTO(Book book) {
        BookDTO bookDto = new BookDTO();
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthorDto(AuthorMapper.toDTO(book.getAuthor()));
        bookDto.setSummary(book.getSummary());
        bookDto.setCategoryDto(CategoryMapper.toDTO(book.getCategory()));
        bookDto.setIdBook(book.getIdBook());
        bookDto.setPublicationDate(book.getPublicationDate());

        return bookDto;
    }

    public static BookDTO toDTO(Map.Entry<Book, Integer> pair) {
        BookDTO bookDto = new BookDTO();
        bookDto.setIdBook(pair.getKey().getIdBook());
        bookDto.setTitle(pair.getKey().getTitle());
        bookDto.setAuthorDto(AuthorMapper.toDTO(pair.getKey().getAuthor()));
        bookDto.setCategoryDto(CategoryMapper.toDTO(pair.getKey().getCategory()));
        bookDto.setNumberOfCopies(pair.getValue());
        bookDto.setSummary(pair.getKey().getSummary());
        bookDto.setPublicationDate(pair.getKey().getPublicationDate());
        return bookDto;
    }

    public static Book toEntity(BookDTO bookDto) {
        Book book = new Book();
        return book;
    }

}
