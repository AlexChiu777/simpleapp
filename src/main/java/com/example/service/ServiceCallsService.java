package com.example.service;

import com.example.local.ServiceCallList;
import com.example.model.ServiceCall;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by alex on 1/4/2018.
 */
public class ServiceCallsService {
    List<ServiceCall> serviceCallList = ServiceCallList.getInstance();

    public List<ServiceCall> getAllServiceCalls() {
        return serviceCallList;
    }

    public List<ServiceCall> searchServiceCallsByClient (long clientID) {
        Comparator<ServiceCall> groupByComparator = Comparator.comparing(ServiceCall::getClientID);

        List<ServiceCall> result = serviceCallList
                .stream()
                .filter(e -> e.getClientID()==clientID)
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }

    public ServiceCall getServiceCall(long id) throws Exception {
        Optional<ServiceCall> match
                = serviceCallList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The ServiceCall id " + id + " not found");
        }
    }

    public long addServiceCall(ServiceCall client) {
        serviceCallList.add(client);
        return client.getId();
    }

    public boolean updateServiceCall(ServiceCall customer) {
        int matchIdx = 0;
        Optional<ServiceCall> match = serviceCallList.stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = serviceCallList.indexOf(match.get());
            serviceCallList.set(matchIdx, customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteServiceCall(long id) {
        Predicate<ServiceCall> contractor = e -> e.getId() == id;
        if (serviceCallList.removeIf(contractor)) {
            return true;
        } else {
            return false;
        }
    }
}
