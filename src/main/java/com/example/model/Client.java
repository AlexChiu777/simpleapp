package com.example.model;

/**
 * Created by alex on 1/4/2018.
 */
public class Client extends Employee {
    private String department;
    private String role;


    public Client(String firstName, String lastName, String department, String role, String address, String phoneNumber, String email, String password) {
        super(firstName, lastName, address, phoneNumber, email, password, EmployeeType.CLIENT);
        this.department = department;
        this.role = role;
    }

    public Client(long id, String firstName, String lastName, String department, String role, String address, String phoneNumber, String email, String password) {
        super(id, firstName, lastName, address, phoneNumber, email, password, EmployeeType.CLIENT);
        this.department = department;
        this.role = role;
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


}
