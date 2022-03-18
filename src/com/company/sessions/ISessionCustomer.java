package com.company.sessions;

import com.company.IOrder;
import com.company.IVirtualStore;
import com.company.users.ARealStore;

import java.util.List;

public interface ISessionCustomer {
    List<IOrder> getOrders();

    IVirtualStore getPickedStore();

    void setPickedStore(IVirtualStore store);
}
