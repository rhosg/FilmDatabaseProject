package com.sparta.pdf.services;

import com.sparta.pdf.components.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class RegistrationService {

    @PersistenceContext
    private EntityManager entityManager;
    public String registerUser(User user) {
        entityManager.persist(user);
        return "welcome";
    }
}
