package com.company.users;

import com.company.IOrder;
import com.company.IVirtualStore;

import java.util.List;

public interface IRealStore {
    public List<IVirtualStore> getVirtualStore();
    public boolean addOrder(IOrder order); // confirm new order
    public String getContact();

}
