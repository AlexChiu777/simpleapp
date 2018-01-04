package com.example.service;

import com.example.local.ContractorList;
import com.example.model.Contractor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by alex on 1/4/2018.
 */
public class ContractorService {
    List<Contractor> contractorList = ContractorList.getInstance();

    public List<Contractor> getAllContractors() {
        return contractorList;
    }

    public List<Contractor> searchContractorsByName(String name) {
        Comparator<Contractor> groupByComparator = Comparator.comparing(Contractor::getFirstName)
                .thenComparing(Contractor::getLastName);
        List<Contractor> result = contractorList
                .stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase(name) || e.getLastName().equalsIgnoreCase(name))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }

    public Contractor getContractor(long id) throws Exception {
        Optional<Contractor> match
                = contractorList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Contractor id " + id + " not found");
        }
    }

    public long addContractor(Contractor client) {
        contractorList.add(client);
        return client.getId();
    }

    public boolean updateContractor(Contractor customer) {
        int matchIdx = 0;
        Optional<Contractor> match = contractorList.stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = contractorList.indexOf(match.get());
            contractorList.set(matchIdx, customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteContractor(long id) {
        Predicate<Contractor> contractor = e -> e.getId() == id;
        if (contractorList.removeIf(contractor)) {
            return true;
        } else {
            return false;
        }
    }
}
