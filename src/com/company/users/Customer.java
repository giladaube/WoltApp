package com.company.users;

import com.company.*;

import java.util.List;

// NEED TO ADD Observer
public class Customer extends User {
    private OrderHandle orderHandle;
    public Customer(String name, String pass, Location loc){
        super(name, pass, UserType.CUSTOMER, loc);
    }
    public Customer(String name, String pass){
        super(name, pass, UserType.CUSTOMER, Location.generateRandomLocation());
        orderHandle = new OrderHandle();
    }
    public void addOrder(List<IItem> items, IVirtualStore store) {
        orderHandle.addOrder(store.newOrder(items));
    }
    public List<IOrder> getOrders(){return orderHandle.getOrders();}
}
