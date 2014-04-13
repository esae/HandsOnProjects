/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.handson3.test;

import ch.fhnw.bscwi.esae.handson3.domain.Book;
import ch.fhnw.bscwi.esae.handson3.ejb.BookEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import static org.junit.Assert.*;

/**
 *
 * @author andreas.martin
 */
@Singleton
@Startup
public class BookStartupSingletonTest {
    
    @EJB
    private BookEJB bookEJB;

    @PostConstruct
    void init() {
        try {
            shouldCreateABook();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void shouldCreateABook() throws Exception {
        Book book = new Book();
        book.setTitle("HelloNew");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy book");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);
        book = bookEJB.createBook(book);
        assertNotNull("ID should not be null", book.getId());
        List<Book> books = bookEJB.findBooks();
        assertNotNull(books);
    }
}
