package org.compain.library.service;

import org.compain.library.model.Book;
import org.compain.library.model.Copy;
import org.compain.library.service.DTO.BookDTO;
import org.compain.library.service.DTO.CopyDTO;

public class CopyMapper {

    public static CopyDTO toDTO(Copy copy){
        CopyDTO copyDto = new CopyDTO();
        copyDto.setBookDto(BookMapper.toDTO(copy.getBook()));
        return copyDto;
    }

    public static Copy toEntity(CopyDTO copyDto){
        Copy copy = new Copy();
        return copy;
    }
}
