package com.company.users;

import com.company.IOrder;
import com.company.IVirtualStore;

public interface IRealStore {
    public IVirtualStore getVirtualStore(); // remove ????
    public boolean addOrder(IOrder order);  // confirm new order
    public String getContact();

}
