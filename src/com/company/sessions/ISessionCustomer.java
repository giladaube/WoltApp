package com.company.sessions;

import com.company.orders.IOrder;
import com.company.users.IVirtualStore;

import java.util.List;

public interface ISessionCustomer {
    List<IOrder> getOrders();

    IVirtualStore getPickedStore();

    void setPickedStore(IVirtualStore store);
}
