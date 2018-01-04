package com.example.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alex on 1/4/2018.
 */
public class Contractor {
    private static final AtomicLong counter = new AtomicLong(100);

    private long id;
    private String firstName;
    private String lastName;

    private String phoneNumber;

    private String email;
    private String password;

    private int rating;
    private List<String> reviews;

    public Contractor(String firstName, String lastName, String phoneNumber, String email, String password) {
        this.id = counter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Contractor(long id, String firstName, String lastName, String phoneNumber, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
}
