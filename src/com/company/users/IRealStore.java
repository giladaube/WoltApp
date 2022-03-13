package com.company.users;

import com.company.IItem;
import com.company.IOrder;
import com.company.IVirtualStore;

import java.util.List;

public interface IRealStore {
    IVirtualStore getVirtualStore(); // remove ????
    List<IItem> getItems();
    boolean addOrder(IOrder order);  // confirm new order
    String getContact();

}
