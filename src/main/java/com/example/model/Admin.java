package com.example.model;

/**
 * Created by alex on 1/14/2018.
 */
public class Admin extends Employee {
    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, null, null, email, password, EmployeeType.ADMIN);
    }

    public Admin(long id, String firstName, String lastName, String email, String password) {
        super(id, firstName, lastName, null, null, email, password, EmployeeType.ADMIN);
    }
}
