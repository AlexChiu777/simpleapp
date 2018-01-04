package com.example.local;

import com.example.model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 1/4/2018.
 */
public class ClientList {
    private static final List<Client> clientList = new ArrayList();

    private ClientList(){
    }

    static{
        clientList.add(new Client("Alex Chiu", "Tech", "Manager", "18 Some Address Crs", "4114114234", "alex@abc.com", "1234"));
        clientList.add(new Client("John", "Sales", "Manager", "20 Some Address Crs", "4114114234", "john@abc.com", "1234"));

    }

    public static List <Client> getInstance(){
        return clientList;
    }
}
