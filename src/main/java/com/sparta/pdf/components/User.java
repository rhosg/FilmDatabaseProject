package com.sparta.pdf.components;

import javax.persistence.*;

@Entity
@Table(name = "users")

//@NamedQueries({
@NamedQuery(
        name = "getUsernameAndPassword",
        query = "SELECT u FROM User u WHERE u.username = :usernameInput "
)
//})

public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "customer_id")
    private String customerId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "customer_id")
    private Customer customer;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserPassword() {
        return userPassword;
    }
}

