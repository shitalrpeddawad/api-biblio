package org.compain.library.consumer;

import org.compain.library.model.Book;
import org.compain.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

 List<Category> findAll();
 Category findByName(String name);
 Category findByIdCategory(Integer idCategory );

}
