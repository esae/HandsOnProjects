package ch.fhnw.bscwi.esae.handson2;

import ch.fhnw.bscwi.esae.handson2.domain.Address;
import ch.fhnw.bscwi.esae.handson2.domain.Customer;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	Address address = new Address("Hauptstrasse", "Olten", "4600", "Switzerland");
        Customer customer = new Customer();
        customer.setFirstName("Andreas");
        customer.setLastName("Martin");
        customer.setEmail("andreas.martin@fhnw.ch");
        customer.setDateOfBirth(new GregorianCalendar(1983, 04, 21).getTime());
        customer.setAddress(address);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "primary");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();

    }
}
