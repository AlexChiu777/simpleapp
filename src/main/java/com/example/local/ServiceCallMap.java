package com.example.local;

import com.example.model.Employee;
import com.example.model.ServiceCall;
import com.example.model.ServiceCallStatus;
import com.example.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 1/4/2018.
 */
public class ServiceCallMap {
    private static final Map<Long, List<ServiceCall>> serviceCallMap = new HashMap<>();

    private ServiceCallMap(){
    }

    public static Map<Long, List<ServiceCall>> getInstance(){
        return serviceCallMap;
    }

    static{
        try {
            List<ServiceCall> list = new ArrayList<>();
            list.add(new ServiceCall("LightBulb", "somewhere", 111L));
            list.add(new ServiceCall("Plumbing", "somewhereElse", 111L));
            list.add(new ServiceCall("Tubes", "Ellina", 111L, ServiceCallStatus.ACCEPTED));
            list.add(new ServiceCall("Eeek", "Henesys", 111L, ServiceCallStatus.COMPLETE));
            list.add(new ServiceCall("Serious Business", "Victoria Island", 111L, ServiceCallStatus.INCOMPLETE));


            serviceCallMap.put(111L, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}