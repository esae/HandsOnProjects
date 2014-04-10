/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.handson1;

import ch.fhnw.bscwi.esae.handson1.domain.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author andreas.martin
 */
public class Main 
{
    public static void main( String[] args )
    {
        Book book = new Book();
        book.setTitle("Java EE");
        book.setPrice(12.5F);
        book.setDescription("Java EE 6");
        book.setIsbn("1-4564-777-8");
        book.setNbOfPage(254);
        book.setIllustrations(Boolean.FALSE);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "ch.fhnw.bscwi.esae_hands-on-1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
        emf.close();
    }
}
