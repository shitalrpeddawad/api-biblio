package org.compain.library.service.DTO;

public class CopyDTO {
    private Long idCopy;
    private BookDTO bookDto;
    private LibraryDTO libraryDto;
    private Boolean available;

    public Long getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Long idCopy) {
        this.idCopy = idCopy;
    }

    public BookDTO getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDTO bookDto) {
        this.bookDto = bookDto;
    }

    public LibraryDTO getLibraryDto() {
        return libraryDto;
    }

    public void setLibraryDto(LibraryDTO libraryDto) {
        this.libraryDto = libraryDto;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
