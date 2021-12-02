package com.company.users;

import com.company.IItem;
import com.company.IOrder;
import com.company.IVirtualStore;
import com.company.VirtualStoreOwner;

import java.util.ArrayList;
import java.util.List;

public abstract class ARealStore extends User implements IRealStore {
    protected List<VirtualStoreOwner> stores;
    protected List<IOrder> orders;

    public void addStore(String name) {
        stores.add(new VirtualStoreOwner(this, name));
    }

    public void addStore(String name, IItem item) {
        VirtualStoreOwner s = new VirtualStoreOwner(this, name);
        s.addItem(item);
        stores.add(s);
    }

    public void addStore(String name, List<IItem> items) {
        VirtualStoreOwner s = new VirtualStoreOwner(this, name);
        s.addItems(items);
        stores.add(s);
    }

    @Override
    public List<IVirtualStore> getVirtualStore() {
        return new ArrayList<IVirtualStore>(stores);
    }
    @Override
    public abstract boolean addOrder(IOrder order); // return confirmation on new order
    @Override
    public abstract String getContact();
}
