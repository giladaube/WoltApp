package com.company;

import com.company.users.ARealStore;
import com.company.users.User;

public interface IDatabase {
    User checkUserExists(String name, String password);
    void saveUser(User user);
    void deleteUser(User user);
    int addOrder(IOrder order);

    ARealStore getStore(ISearchStrategy comparator);
}
