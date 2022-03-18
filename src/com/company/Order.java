package com.company;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder {
    private List<IItem> items;
    private IVirtualStore store;
    private int orderId;

    public Order(List<IItem> items, IVirtualStore store) {
        this.items = items;
        this.store = store;
    }

    @Override
    public void setOrderNumber(int id) {
        orderId = id;
    }

    @Override
    public int getOrderNumber() {
        return orderId;
    }

    @Override
    public List<IItem> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public IVirtualStore getStore() {
        return store;
    }

    @Override
    public double getPrice() {
        float totalPrice = 0;
        for (IItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Order number: ").append(orderId).append(", have the following items:\n");
        for (IItem item : items) {
            result.append(item.toString());
        }
        result.append("\n").append("Total cost: ").append(getPrice()).append(".");
        return result.toString();
    }
}
