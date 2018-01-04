/* Copyright � 2015 Oracle and/or its affiliates. All rights reserved. */
package com.example.service;

import com.example.local.ClientList;
import com.example.model.Client;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ClientService {

    List<com.example.model.Client> clientList = ClientList.getInstance();

    public List<com.example.model.Client> getAllClients() {
        return clientList;
    }

    public List<Client> searchClientsByName(String name) {
        Comparator<Client> groupByComparator = Comparator.comparing(Client::getName);
        List<Client> result = clientList
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }

    public Client getClient(long id) throws Exception {
        Optional<Client> match
                = clientList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Client id " + id + " not found");
        }
    }   

    public long addClient(Client client) {
        clientList.add(client);
        return client.getId();
    }

    public boolean updateClient(Client customer) {
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

    public boolean deleteClient(long id) {
        Predicate<Client> employee = e -> e.getId() == id;
        if (clientList.removeIf(employee)) {
            return true;
        } else {
            return false;
        }
    }
}
