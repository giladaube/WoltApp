package com.company;

import com.company.users.ISupplier;

import java.util.List;

public interface IOrder {
    public List<IItem> getItems();
    public IStore getStore();
    public float getPrice();
}
