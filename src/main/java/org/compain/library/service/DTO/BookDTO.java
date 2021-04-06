package org.compain.library.service.DTO;

import org.compain.library.model.Category;
import java.util.Date;
import java.util.List;

public class BookDTO {


    private Long idBook;
    private String title;
    private AuthorDTO authorDto;
    private Date publicationDate;
    private String summary;
    private CategoryDTO categoryDto;
    private List<CopyDTO> copiesDto;

    public AuthorDTO getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDTO authorDto) {
        this.authorDto = authorDto;
    }

    public List<CopyDTO> getCopiesDto() {
        return copiesDto;
    }

    public void setCopiesDto(List<CopyDTO> copiesDto) {
        this.copiesDto = copiesDto;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public CategoryDTO getCategory() {
        return categoryDto;
    }

    public void setCategory(CategoryDTO category) {
        this.categoryDto = category;
    }

}