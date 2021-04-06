package org.compain.library.service;

import org.compain.library.consumer.AuthorRepository;
import org.compain.library.model.Author;
import org.compain.library.service.DTO.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    List<AuthorDTO> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(AuthorMapper::toDTO).collect(toList());
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);

    }


}
