package com.company;

import com.company.users.ISupplier;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder {
    private List<IItem> items;
    private IStore store;

    public Order(List<IItem> items, IStore store) {
        this.items = items;
        this.store = store;
    }

    @Override
    public List<IItem> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public IStore getStore() {
        return store;
    }

    @Override
    public float getPrice() {
        float totalPrice = 0;
        for (IItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
