package org.compain.library.service.DTO;

import java.util.List;

public class CategoryDTO {

    private Integer idCategory;
    private String name;
    private String description;
    private List<BookDTO> booksDto;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookDTO> getBooksDto() {
        return booksDto;
    }

    public void setBooksDto(List<BookDTO> booksDto) {
        this.booksDto = booksDto;
    }
}
