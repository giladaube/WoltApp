package com.company.sessions;

import com.company.IOrder;
import com.company.IVirtualStore;
import com.company.users.ARealStore;
import com.company.users.Customer;

import java.util.List;

public class SessionCustomer implements ISessionCustomer{
    private Customer customer;
    private IVirtualStore store;

    public SessionCustomer(Customer c) {
        customer = c;
    }
    @Override
    public List<IOrder> getOrders() {
        return customer.getOrders();
    }

    @Override
    public IVirtualStore getPickedStore() {
        return store;
    }

    @Override
    public void setPickedStore(IVirtualStore store) {
        this.store=store;
    }
}
