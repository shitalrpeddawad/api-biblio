package org.compain.library.consumer;


import org.compain.library.model.Book;
import org.compain.library.model.Library;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements IBookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> search(String title, String authorName, String categoryName, String idBook) {
        String sql = "SELECT s FROM " + Book.class.getName() + " s" + " WHERE 1=1 ";
        Map<String, String> parameters = new HashMap<>();

        if (title != null && !title.equals("")) {
            sql = sql + "AND s.title= :title";
            parameters.put("title", title);
        }

        if (authorName != null && !authorName.equals("")) {
            sql = sql + "AND s.author.name= :authorName";
            parameters.put("authorName", authorName);
        }

        if (categoryName != null && !categoryName.equals("")) {
            sql = sql + "AND s.category.name= :categoryName";
            parameters.put("categoryName", categoryName);
        }

        if (idBook != null && !idBook.equals("")) {
            sql = sql + "AND s.category.name= :categoryName";
            parameters.put("idBook", idBook);
        }

        TypedQuery<Book> query = entityManager.createQuery(sql, Book.class);
        parameters.forEach(query::setParameter);

        return query.getResultList();
    }
}
