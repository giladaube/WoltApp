package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order implements IOrder {
    private List<IItem> items;
    private IVirtualStore store;
    private int orderId;
    private int status;
    private Observer orderHandleListener;

    public Order(List<IItem> items, IVirtualStore store, Observer orderHandleListener) {
        this.orderId = UUID.randomUUID().hashCode();
        this.status = 0;
        this.items = items;
        this.store = store;
        this.orderHandleListener = orderHandleListener;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
        notifySubscribers(status);
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void addSubscriber(Observer observer) {
        orderHandleListener = observer;
    }

    @Override
    public void removeSubscriber(Observer observer) {

    }

    @Override
    public void notifySubscribers(String tweet) {

    }

    @Override
    public void notifySubscribers(int OrderID) {
        orderHandleListener.update(OrderID);
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
        result.append("-----------------------------------\n");
        result.append("Order number    [").append(orderId).append("]\n");
        result.append("Items:\n");
        result.append("-----------------------------------\n");

        for (IItem item : items) {
            result.append(item.toString());
            result.append("-----------------------------------\n");
        }
        result.append("Total cost:     ").append(getPrice()).append("\n");
        return result.toString();
    }


}
