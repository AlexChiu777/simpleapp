package com.example.local;

import com.example.model.Client;
import com.example.model.Contractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 1/4/2018.
 */
public class ContractorList {
    private static final List<Contractor> contractorList = new ArrayList();

    private ContractorList(){
    }

    static{
        contractorList.add(new Contractor("Alex", "Chiu", "1231231234", "alex@abc.com", "1234"));
        contractorList.add(new Contractor("John", "Koo", "1231231234", "john@abc.com", "1234"));
    }

    public static List <Contractor> getInstance(){
        return contractorList;
    }
}
