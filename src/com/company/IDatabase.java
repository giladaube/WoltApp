package com.company;

import com.company.users.ARealStore;
import com.company.users.Customer;
import com.company.users.User;

import java.util.List;

public interface IDatabase {
    User checkUserExists(String name, String password);
    void saveUser(User user);
    void deleteUser(User user);
    int addOrder(IOrder order);
    List<Customer> getCustomers();
    ARealStore getStore(ISearchStrategy comparator);
}
