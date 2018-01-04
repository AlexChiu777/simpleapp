/* Copyright � 2015 Oracle and/or its affiliates. All rights reserved. */
package com.example.employees;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class EmployeeService {

    List<Client> clientList = EmployeeList.getInstance();

    public List<Client> getAllEmployees() {
        return clientList;
    }

    public List<Client> searchEmployeesByName(String name) {
        Comparator<Client> groupByComparator = Comparator.comparing(Client::getName)
                                                    .thenComparing(Client::getLastName);
        List<Client> result = clientList
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name) || e.getLastName().equalsIgnoreCase(name))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }

    public Client getEmployee(long id) throws Exception {
        Optional<Client> match
                = clientList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Employee id " + id + " not found");
        }
    }   

    public long addEmployee(Client client) {
        clientList.add(client);
        return client.getId();
    }

    public boolean updateEmployee(Client customer) {
        int matchIdx = 0;
        Optional<Client> match = clientList.stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = clientList.indexOf(match.get());
            clientList.set(matchIdx, customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEmployee(long id) {
        Predicate<Client> employee = e -> e.getId() == id;
        if (clientList.removeIf(employee)) {
            return true;
        } else {
            return false;
        }
    }
}
