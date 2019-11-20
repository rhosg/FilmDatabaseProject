package com.sparta.pdf.components;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "getUsernameAndPassword",
                query = "SELECT u.username, u.userPassword FROM User u WHERE u.username = :usernameInput AND u.userPassword = :userPasswordInput"
        ),
        @NamedQuery(name = "validationOfUsername",
                query = "SELECT u.username FROM User u WHERE u.username = :usernameInput"),
        @NamedQuery(name = "getEmail",
                query = "SELECT u.email FROM User u WHERE u.email = :emailInput")

})

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;


//    @OneToOne
//    @PrimaryKeyJoinColumn(name = "customer_id")
//    private Customer customer;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
}

