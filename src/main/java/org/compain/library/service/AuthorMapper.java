package org.compain.library.service;

import org.compain.library.model.Author;
import org.compain.library.service.DTO.AuthorDTO;

public class AuthorMapper {

    public static AuthorDTO toDTO(Author author){
        AuthorDTO authorDto = new AuthorDTO();
        authorDto.setName(author.getName());
        authorDto.setFirstname(author.getFirstname());
        return authorDto;
    }

    public static Author toEntity(AuthorDTO authorDto){
        Author author =  new Author();
        author.setName(authorDto.getName());
        author.setFirstname(authorDto.getFirstname());

        return author;
    }
}
