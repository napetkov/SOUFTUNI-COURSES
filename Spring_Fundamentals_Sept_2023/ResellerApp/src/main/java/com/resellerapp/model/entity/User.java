package com.resellerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
//    @Length(min = 2,max = 20)
//    @Column(unique = true,nullable = false)
//    private String username;

    @NotNull
    @Length(min = 2,max = 20)
    private String password;

    @Email
    @Column(unique = true)
    @NotNull
    private String email;

    @OneToMany(mappedBy = "createdBy")
    private Set<Offer> offers;

    @OneToMany(mappedBy = "boughtBy")
    private Set<Offer> boughtOffers;

    public User() {
        this.offers = new HashSet<>();
        this.boughtOffers = new HashSet<>();
    }

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

    public Set<Offer> getOffers() {
        return offers;
    }

    public User setOffers(Set<Offer> offers) {
        this.offers = offers;
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
