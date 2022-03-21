package com.company.users;

import com.company.orders.IItem;
import com.company.orders.IOrder;

import java.util.List;
// VirtualStore is a reflection of a real store that is presented to the Costumer
public class VirtualStore implements IVirtualStore {
    private IRealStore realStore;   // ref to real store

    public VirtualStore(IRealStore s) {
        realStore = s;
    }
    @Override
    public List<IItem> getItems() {
        return realStore.getItems();
    }

    @Override
    public String getStoreName() {
        return realStore.getStoreName();
    }

//    @Override
//    public IOrder newOrder(List<IItem> items) {
//        return new Order(items, this, new OrderHandle());
//    }

    @Override
    public boolean addOrder(IOrder order) throws InterruptedException {
        return realStore.addOrder(order);
    }
}
