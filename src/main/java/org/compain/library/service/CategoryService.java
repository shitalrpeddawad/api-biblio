package org.compain.library.service;

import org.compain.library.consumer.CategoryRepository;
import org.compain.library.model.Book;
import org.compain.library.model.Category;
import org.compain.library.service.DTO.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toDTO).collect(toList());
    }



}
