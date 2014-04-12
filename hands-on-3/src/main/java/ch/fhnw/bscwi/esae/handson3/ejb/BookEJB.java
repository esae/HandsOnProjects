/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.handson3.ejb;

import ch.fhnw.bscwi.esae.handson3.domain.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author andreas.martin
 */
@Stateless
public class BookEJB {

    @PersistenceContext(unitName = "ch.fhnw.bscwi.esae_hands-on-3_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery("findAllBooks", Book.class);
        return query.getResultList();
    }

    public Book findBookById(Long id) {
        return em.find(Book.class, id);
    }

    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    public void deleteBook(Book book) {
        em.remove(em.merge(book));
    }

    public Book updateBook(Book book) {
        return em.merge(book);
    }
}
