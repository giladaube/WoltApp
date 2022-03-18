package com.company;

import com.company.users.IRealStore;

import java.util.List;

public interface IVirtualStore {
    List<IItem> getItems();
    String getStoreName();
    IOrder newOrder(List<IItem> items);

    boolean addOrder(IOrder order);
}
