package com.company.db;

import com.company.orders.IOrder;
import com.company.strategy.ISearchStrategy;
import com.company.users.RealStore;
import com.company.users.User;

public interface IDatabase {
    User checkUserExists(String name, String password);
    void saveUser(User user);
    void deleteUser(User user);
    int addOrder(IOrder order);
    RealStore getBestStore(ISearchStrategy comparator);
}
