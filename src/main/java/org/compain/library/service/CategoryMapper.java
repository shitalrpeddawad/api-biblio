package org.compain.library.service;


import org.compain.library.model.Category;
import org.compain.library.service.DTO.CategoryDTO;


public class CategoryMapper {

    public static CategoryDTO toDTO(Category category){
        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }

    public static Category toEntity(CategoryDTO categoryDto){
       Category category = new Category();
       category.setName(categoryDto.getName());
       category.setDescription(categoryDto.getDescription());
        return category;
    }
}
