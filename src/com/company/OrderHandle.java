package com.company;

import java.util.List;

// NEED TO ADD Observable
public class OrderHandle {
    private List<IOrder> orders;

    public void addOrder(IOrder order) {
        orders.add(order);
        boolean confirmation = order.getStore().getRealStore().addOrder(order);
        // NEED TO NOTIFY CUSTOMER ABOUT CONFIRMATION
    }
}
