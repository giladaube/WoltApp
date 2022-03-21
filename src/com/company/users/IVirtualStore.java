package com.company.users;

import com.company.orders.IItem;
import com.company.orders.IOrder;

import java.util.List;

public interface IVirtualStore {
    List<IItem> getItems();
    String getStoreName();
//    IOrder newOrder(List<IItem> items);

    boolean addOrder(IOrder order) throws InterruptedException;
}
