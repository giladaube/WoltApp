package com.company.db;

import com.company.IOrder;
import com.company.strategy.ISearchStrategy;
import com.company.users.ARealStore;
import com.company.users.Customer;
import com.company.users.User;

import java.util.List;

public interface IDatabase {
    User checkUserExists(String name, String password);
    void saveUser(User user);
    void deleteUser(User user);
    int addOrder(IOrder order);
    ARealStore getBestStore(ISearchStrategy comparator);
}
