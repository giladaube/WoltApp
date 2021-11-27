package com.company.users;

import com.company.IOrder;
import com.company.IStore;

import java.util.List;

public interface ISupplier {
    public List<IStore> getStores();
    public boolean addOrder(IOrder order); // confirm new order
    public String getContact();

}
