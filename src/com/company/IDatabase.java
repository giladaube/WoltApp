package com.company;

import com.company.users.IRealStore;
import com.company.users.User;

import java.util.List;

public interface IDatabase {
    User checkUserExists(String name, String password);
    void addUser(User user, String password);
    List<IRealStore> getStores();
    int addOrder(IOrder order);
}
