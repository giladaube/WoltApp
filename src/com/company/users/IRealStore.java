package com.company.users;

import com.company.orders.IItem;
import com.company.orders.IOrder;

import java.util.List;

public interface IRealStore {
    IVirtualStore getVirtualStore();
    List<IItem> getItems();
    boolean addOrder(IOrder order) throws InterruptedException;  // confirm new order
    String getContact();
    double getRating();
    String getStoreName();

}
