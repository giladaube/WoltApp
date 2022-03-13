package com.company.sessions;

import com.company.IOrder;

import java.util.List;

public interface ISessionCustomer {
    List<IOrder> getOrders();
}
