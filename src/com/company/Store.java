package com.company;

import com.company.users.ISupplier;

import java.util.ArrayList;
import java.util.List;

public class Store implements IStore {
    private String name;
    private ISupplier supplier;
    protected List<IItem> items;

    public Store(ISupplier s, String name) {
        this.name = name;
        supplier = s;
        items = new ArrayList<>();
    }
    @Override
    public List<IItem> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public ISupplier getSupplier() {
        return supplier;
    }

    @Override
    public IOrder newOrder(List<IItem> items) {
        return new Order(items, this);
    }
}
