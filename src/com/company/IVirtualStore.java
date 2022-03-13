package com.company;

import com.company.users.IRealStore;

import java.util.List;

public interface IVirtualStore {
    List<IItem> getItems();
    IRealStore getRealStore();
    IOrder newOrder(List<IItem> items);

}
