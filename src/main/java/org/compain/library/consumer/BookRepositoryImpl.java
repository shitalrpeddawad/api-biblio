package org.compain.library.consumer;


import org.compain.library.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepositoryImpl implements IBookRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> search(String title, String authorName, String categoryName){
        String queryString = "ma super requete";
        TypedQuery<Book> query = entityManager.createQuery(queryString, Book.class);
        //query.setParameter();
        return query.getResultList();
    }

}
