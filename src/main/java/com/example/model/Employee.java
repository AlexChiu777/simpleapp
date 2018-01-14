package com.example.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alex on 1/14/2018.
 */
public class Employee {
    public static final AtomicLong counter = new AtomicLong(100);

    public long id;
    public String firstName;
    public String lastName;

    public EmployeeType type;

    public String address;
    public String phoneNumber;

    public String email;
    public String password;

    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String password, EmployeeType type) {
        this.id = counter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public Employee(long id, String firstName, String lastName, String address, String phoneNumber, String email, String password, EmployeeType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.address = address;
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

    public static AtomicLong getCounter() {
        return counter;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }
}
