package com.example.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alex on 1/4/2018.
 */
public class Client {
    private static final AtomicLong counter = new AtomicLong(100);

    private long id;
    private String name;
    private String department;
    private String role;
    private String address;
    private String phoneNumber;

    private String email;
    private String password;

    public Client(String name, String department, String role, String address, String phoneNumber, String email, String password) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.department = department;
        this.role = role;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Client(long id, String name, String department, String role, String address, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
