/* Copyright � 2015 Oracle and/or its affiliates. All rights reserved. */
package com.example.employees;

import java.util.ArrayList;
import java.util.List;


public class EmployeeList {
    private static final List<Client> CLIENT_LIST = new ArrayList();
    
    private EmployeeList(){
    }
    
    static{
        CLIENT_LIST.add(new Client("John","Smith","12-12-1980","Manager","Sales","john.smith@abc.com"));
        CLIENT_LIST.add(new Client("Laura","Adams","02-11-1979","Manager","IT","laura.adams@abc.com"));
        CLIENT_LIST.add(new Client("Peter","Williams","22-10-1966","Coordinator","HR","peter.williams@abc.com"));
        CLIENT_LIST.add(new Client("Joana","Sanders","11-11-1976","Manager","Marketing","joana.sanders@abc.com"));
        CLIENT_LIST.add(new Client("John","Drake","18-08-1988","Coordinator","Finance","john.drake@abc.com"));
        CLIENT_LIST.add(new Client("Samuel","Williams","22-03-1985","Coordinator","Finance","samuel.williams@abc.com"));
    }
    
    public static List <Client> getInstance(){
        return CLIENT_LIST;
    }
}
