package com.company;

import com.company.users.IRealStore;

import java.util.List;

public class VirtualStoreOwner extends VirtualStore {

    public VirtualStoreOwner(IRealStore s, String name) {
        super(s, name);
    }

    public void addItem(IItem item) {
        items.add(item);
    }

    public void addItems(List<IItem> items) {
        this.items.addAll(items);
    }

    public void removeItem(IItem item) {
        items.remove(item);
    }
}
