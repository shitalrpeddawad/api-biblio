package org.compain.library.service;

import org.compain.library.model.Book;
import org.compain.library.model.Library;
import org.compain.library.service.DTO.BookDTO;
import org.compain.library.service.DTO.LibraryDTO;

import java.util.Map;

public class LibraryMapper {

    public static LibraryDTO toDTO(Library library) {
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setAddress(library.getAddress());
        libraryDTO.setEmail(library.getEmail());
        libraryDTO.setPhone(library.getPhone());
        return libraryDTO;
    }

    public static Library toEntity(LibraryDTO libraryDTO) {
        Library library = new Library();
        library.setAddress(libraryDTO.getAddress());
        library.setEmail(libraryDTO.getEmail());
        library.setPhone(libraryDTO.getPhone());
        return library;
    }
}
