package com.example.model;

import java.util.List;

/**
 * Created by alex on 1/4/2018.
 */
public class Contractor extends Employee {
    private int rating;
    private List<String> reviews;

    public Contractor(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, null, phoneNumber, email, password, EmployeeType.CONTRACTOR);
    }

    public Contractor(long id, String firstName, String lastName, String phoneNumber, String email, String password) {
        super(id, firstName, lastName, null, phoneNumber, email, password, EmployeeType.CONTRACTOR);
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
