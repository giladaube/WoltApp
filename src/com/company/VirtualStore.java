package com.company;

import com.company.users.IRealStore;

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
    public IRealStore getRealStore() {
        return realStore;
    }

    @Override
    public IOrder newOrder(List<IItem> items) {
        return new Order(items, this);
    }
}
