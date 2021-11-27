package com.company.users;

import com.company.IItem;
import com.company.IOrder;
import com.company.IStore;
import com.company.StoreOwner;

import java.util.ArrayList;
import java.util.List;

public abstract class ASupplier extends User implements ISupplier {
    protected List<StoreOwner> stores;
    protected List<IOrder> orders;

    public void addStore(String name) {
        stores.add(new StoreOwner(this, name));
    }

    public void addStore(String name, IItem item) {
        StoreOwner s = new StoreOwner(this, name);
        s.addItem(item);
        stores.add(s);
    }

    public void addStore(String name, List<IItem> items) {
        StoreOwner s = new StoreOwner(this, name);
        s.addItems(items);
        stores.add(s);
    }

    @Override
    public List<IStore> getStores() {
        return new ArrayList<IStore>(stores);
    }
    @Override
    public abstract boolean addOrder(IOrder order); // return confirmation on new order
    @Override
    public abstract String getContact();
}
