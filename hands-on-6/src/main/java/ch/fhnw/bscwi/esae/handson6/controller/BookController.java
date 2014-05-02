/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.handson6.controller;

import ch.fhnw.bscwi.esae.handson6.business.BookEJB;
import ch.fhnw.bscwi.esae.handson6.domain.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author andreas.martin
 */
@Named
@RequestScoped
public class BookController {

    public BookController() {
    }
    @EJB
    private BookEJB bookEJB;
    private Book book = new Book();
    private List<Book> bookList = new ArrayList<>();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        bookList = bookEJB.findBooks();
        return bookList;
    }

    public String doCreateBook() {
        book = bookEJB.createBook(book);
        bookList = bookEJB.findBooks();
        return "doCreateBook_success";
    }
    
    public String shouldCreateBook() {
        return "shouldCreateBook";
    }
}

