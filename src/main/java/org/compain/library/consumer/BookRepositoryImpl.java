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

    public List<Book> search(String title, String authorName, String categoryName) {
        String sql = "SELECT DISTINCT s FROM " + Book.class.getName() + " s" +
                " INNER JOIN FETCH s.copies copy" +
                " WHERE 1=1 ";
        Map<String, String> parameters = new HashMap<>();

        if (title != null && !title.equals("")) {
            sql = sql + "AND UPPER(s.title) like  UPPER(:title) ";
            parameters.put("title", "%"+title+"%");
        }

        if (authorName != null && !authorName.equals("")) {
            sql = sql + "AND UPPER(s.author.name) like UPPER(:authorName) ";
            parameters.put("authorName", "%"+authorName+"%");
        }

        if (categoryName != null && !categoryName.equals("")) {
            sql = sql + "AND UPPER(s.category.name) like UPPER(:categoryName) ";
            parameters.put("categoryName", "%"+categoryName+"%");
        }

        TypedQuery<Book> query = entityManager.createQuery(sql, Book.class);
        parameters.forEach(query::setParameter);

        return query.getResultList();
    }
}

