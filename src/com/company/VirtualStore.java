package com.company;

import com.company.users.IRealStore;

import java.util.ArrayList;
import java.util.List;

public class VirtualStore implements IVirtualStore {
    private String name;
    private IRealStore realStore;
    protected List<IItem> items;

    public VirtualStore(IRealStore s, String name) {
        this.name = name;
        realStore = s;
        items = new ArrayList<>();
    }
    @Override
    public List<IItem> getItems() {
        return new ArrayList<>(items);
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
