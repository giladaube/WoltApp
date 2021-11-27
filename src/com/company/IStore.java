package com.company;

import com.company.users.ISupplier;

import java.util.List;

public interface IStore {
    public List<IItem> getItems();
    public ISupplier getSupplier();
    public IOrder newOrder(List<IItem> items);

}
