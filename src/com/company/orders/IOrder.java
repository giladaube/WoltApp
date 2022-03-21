package com.company.orders;

import com.company.observer.Observable;
import com.company.users.IVirtualStore;

import java.util.List;

public interface IOrder extends Observable {


    void notifySubscribers(int OrderID);

    void setOrderNumber(int id);
    void setStatus(int status);
    int getStatus();
    int getOrderNumber();
    List<IItem> getItems();
    IVirtualStore getStore();
    double getPrice();

}
