package com.example.local;

import com.example.model.Admin;
import com.example.model.Client;
import com.example.model.Contractor;
import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 1/4/2018.
 */
public class EmployeeList {
    private static final List<Employee> EMPLOYEE_LIST = new ArrayList();

    private EmployeeList(){
    }

    static{
        EMPLOYEE_LIST.add(new Client(111, "Super", "Employer", "Tech", "SuperEmployer", "18 Some Address Crs", "4114114234", "super@abc.com", "1234"));
        EMPLOYEE_LIST.add(new Client("Alex", "Chiu", "Tech", "Manager", "18 Some Address Crs", "4114114234", "alex@abc.com", "1234"));
        EMPLOYEE_LIST.add(new Client("John", "Smith", "Sales", "Manager", "20 Some Address Crs", "4114114234", "john@abc.com", "1234"));
        EMPLOYEE_LIST.add(new Contractor("Alex", "Chiu", "1231231234", "alex@abc.com", "1234"));
        EMPLOYEE_LIST.add(new Contractor("John", "Koo", "1231231234", "john@abc.com", "1234"));
        EMPLOYEE_LIST.add(new Admin("Alex", "Chiu", "abc@abc.com", "1234"));

    }

    public static List <Employee> getInstance(){
        return EMPLOYEE_LIST;
    }
}
