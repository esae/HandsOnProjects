/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.handson5.controller;

import ch.fhnw.bscwi.esae.handson5.domain.User;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author andreas.martin
 */
@Named(value = "greetingController")
@RequestScoped
public class GreetingController {

    private User user = new User();

    public String askNameAction() {
        //return "askName.xhtml";
        return "askNameAction_called";
    }

    public String greetAction() {
        //return "greet.xhtml";
        return "greetAction_called";
    }

    public String askNameAndGreetAJAXAction() {
        return "askNameAndGreet";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
