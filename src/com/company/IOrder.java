package com.company;

import java.util.List;

public interface IOrder {
    void setOrderNumber(int id);
    int getOrderNumber();
    List<IItem> getItems();
    IVirtualStore getStore();
    float getPrice();
}
