/* Copyright � 2015 Oracle and/or its affiliates. All rights reserved. */
package com.example.service;

import com.example.local.EmployeeList;
import com.example.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class EmployeeService {
    private static EmployeeService employeeService = new EmployeeService();
    private EmployeeService() {
    }

    public static EmployeeService getInstance() {
        return employeeService;
    }

    List<Employee> employeeList = EmployeeList.getInstance();

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public List<Employee> searchEmployeesByName(String name) {
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        List<Employee> result = employeeList
                .stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase(name) || e.getLastName().equalsIgnoreCase(name))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }

    public Employee getEmployee(long id) throws Exception {
        Optional<Employee> match
                = employeeList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Employee id " + id + " not found");
        }
    }

    public Employee getEmployeeByLogin (String email, String password) {
        Optional<Employee> match
                = employeeList.stream()
                .filter(e -> e.getEmail().equalsIgnoreCase(email) && e.getPassword().equals(password))
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        }
        return null;
    }

    public long addEmployee(Employee client) {
        employeeList.add(client);
        return client.getId();
    }

    public boolean updateEmployee(Employee customer) {
        int matchIdx = 0;
        Optional<Employee> match = employeeList.stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = employeeList.indexOf(match.get());
            employeeList.set(matchIdx, customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEmployee(long id) {
        Predicate<Employee> employee = e -> e.getId() == id;
        if (employeeList.removeIf(employee)) {
            return true;
        } else {
            return false;
        }
    }
}
