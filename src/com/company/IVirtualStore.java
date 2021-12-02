package com.company;

import com.company.users.IRealStore;

import java.util.List;

public interface IVirtualStore {
    public List<IItem> getItems();
    public IRealStore getRealStore();
    public IOrder newOrder(List<IItem> items);

}
