package com.company.users;

import com.company.IItem;
import com.company.IOrder;
import com.company.IVirtualStore;

import java.util.List;

public interface IRealStore {
    IVirtualStore getVirtualStore(); // remove ????
    List<IItem> getItems();
    boolean addOrder(IOrder order) throws InterruptedException;  // confirm new order
    String getContact();
    double getRating();
    String getStoreName();

}
