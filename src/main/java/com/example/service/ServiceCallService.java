package com.example.service;

import com.example.local.ServiceCallMap;
import com.example.model.ServiceCall;
import com.example.model.ServiceCallStatus;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by alex on 1/4/2018.
 */
public class ServiceCallService {
    private static ServiceCallService serviceCallService = new ServiceCallService();
    private ServiceCallService() {
    }

    public static ServiceCallService getInstance() {
        return serviceCallService;
    }


    Map<Long, List<ServiceCall>> serviceCallMap = ServiceCallMap.getInstance();

    public List<ServiceCall> getAllServiceCalls() {
        List<ServiceCall> aggregateList = new ArrayList<>();
        for (Long id : serviceCallMap.keySet()) {
            aggregateList.addAll(serviceCallMap.get(id));
        }
        return aggregateList;
    }

    public List<ServiceCall> getServiceCallsForClient(long clientID) {
        if (serviceCallMap.get(clientID) != null) {
            return new ArrayList<>(serviceCallMap.get(clientID));
        } else {
            return new ArrayList<>();
        }
    }

    public List<ServiceCall> getServiceCallsForContractor(long contractorID) {
        List<ServiceCall> serviceCallList = new ArrayList<>();
        for (ServiceCall serviceCall: getAllServiceCalls()) {
            if (serviceCall.getStatus() == ServiceCallStatus.OPEN || serviceCall.getAssignedTo() == contractorID) {
                serviceCallList.add(serviceCall);
            }
        }
        return serviceCallList;
    }

    public ServiceCall getServiceCallById (long id) {
        List<ServiceCall> serviceCallList = getAllServiceCalls();
        Optional<ServiceCall> match
                = serviceCallList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        }
        return null;
    }

  /*  public ServiceCall getSpecifcServiceCall (long clientID, long serviceCallID) throws Exception {
        List<ServiceCall> clientSpecificServiceCall = getServiceCallsForClient(clientID);
        Optional<ServiceCall> match
                = clientSpecificServiceCall.stream()
                .filter(e -> e.getId() == serviceCallID)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The ServiceCall id " + serviceCallID + " not found");
        }
    }*/

    public long addServiceCall(ServiceCall serviceCall) {
        List<ServiceCall> clientSpecificServiceCall = getServiceCallsForClient(serviceCall.getClient().getId());

        if (clientSpecificServiceCall == null) {
            clientSpecificServiceCall = new ArrayList<>();
        }

        clientSpecificServiceCall.add(serviceCall);
        serviceCallMap.put(serviceCall.getClient().getId(), clientSpecificServiceCall);

        return serviceCall.getId();
    }

    public boolean updateServiceCall(ServiceCall tmp) {
        ServiceCall serviceCall = getServiceCallById(tmp.getId());
        if (serviceCall != null) {
            serviceCall.setStatus(tmp.getStatus());
            serviceCall.setAssignedTo(tmp.getAssignedTo());
            serviceCall.setTitle(tmp.getTitle());
            serviceCall.setDescription(tmp.getDescription());
        }
        return true;
    }

}
