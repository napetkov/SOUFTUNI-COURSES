package com.resellerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(nullable = false,unique = true)
    @Length(min = 3,max=20)
    private String username;
    @NotNull
    private String password;
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany(mappedBy = "createBy")
    private Set<Offer> myOffers;
    @OneToMany(mappedBy = "boughtBy")
    private Set<Offer> boughtOffers;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Offer> getMyOffers() {
        return myOffers;
    }

    public User setMyOffers(Set<Offer> myOffers) {
        this.myOffers = myOffers;
        return this;
    }

    public Set<Offer> getBoughtOffers() {
        return boughtOffers;
    }

    public User setBoughtOffers(Set<Offer> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }
}
