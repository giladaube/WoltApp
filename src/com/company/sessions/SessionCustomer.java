package com.company.sessions;

import com.company.IOrder;
import com.company.users.Customer;

import java.util.List;

public class SessionCustomer implements ISessionCustomer{
    private Customer customer;

    public SessionCustomer(Customer c) {
        customer = c;
    }
    @Override
    public List<IOrder> getOrders() {
        return customer.getOrders();
    }
}
