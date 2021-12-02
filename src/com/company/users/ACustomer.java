package com.company.users;

import com.company.*;

import java.util.List;

// NEED TO ADD Observer
public abstract class ACustomer extends User {
    private OrderHandle orderHandle;

    public void addOrder(List<IItem> items, IVirtualStore store) {
        orderHandle.addOrder(store.newOrder(items));
    }
}
