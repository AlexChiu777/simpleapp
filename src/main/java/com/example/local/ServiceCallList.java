package com.example.local;

import com.example.model.ServiceCall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 1/4/2018.
 */
public class ServiceCallList {
    private static final List<ServiceCall> serviceCallList = new ArrayList();

    private ServiceCallList(){
    }

    public static List <ServiceCall> getInstance(){
        return serviceCallList;
    }
}