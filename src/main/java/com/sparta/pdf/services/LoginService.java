package com.sparta.pdf.services;

import com.sparta.pdf.components.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
@Stateless
public class LoginService {
    @PersistenceContext
    EntityManager entityManager;
    public String validateUser(User user) {
        Query query = entityManager.createNamedQuery("getUsernameAndPassword");
        query.setParameter("usernameInput", user.getUsername());
        query.setParameter("userPasswordInput", user.getUserPassword());
        if (query.getResultList().isEmpty()) return "wrongLogIn";
         else  return "welcome";
    }
}
