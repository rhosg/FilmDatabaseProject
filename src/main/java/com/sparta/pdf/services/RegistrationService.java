package com.sparta.pdf.services;

import com.sparta.pdf.components.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
@Stateless
public class RegistrationService {
    @PersistenceContext
    private EntityManager entityManager;

    public String registerUser(User user) {
        Query query = entityManager.createNamedQuery("validationOfUsername");
        query.setParameter("usernameInput", user.getUsername());
        Query query2 = entityManager.createNamedQuery("getEmail");
        query2.setParameter("emailInput", user.getEmail());
        if (query.getResultList().isEmpty() && query2.getResultList().isEmpty()) {
            entityManager.persist(user);
            return "logIn";
        } else {
            return "wrongLogIn";
        }
    }
}
