package com.company;

import com.company.users.ISupplier;

import java.util.List;

public class StoreOwner extends Store {

    public StoreOwner(ISupplier s, String name) {
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
