package com.company.users;

import com.company.IItem;
import com.company.IOrder;
import com.company.IVirtualStore;
import com.company.VirtualStore;

import java.util.ArrayList;
import java.util.List;

// Observed by a Virtual Store? Real Store doesn't need to know about VS presenting him (decoupling)
// maybe doesn't need to be abstract?

// After implement everything here, please go back and create new RealStore at Session class, on setUserType()
public abstract class ARealStore extends User implements IRealStore {
    protected String storeName;
    protected String contactInfo;   // String for now, might be a class
    protected VirtualStore store;   // remove ????
    protected List<IOrder> orders;
    protected List<IItem> items;    // list of items the store is selling

    // CTOR - when opening a new Store
    public ARealStore(String name, String contact){
        storeName = name;
        contactInfo = contact;
        orders = new ArrayList<>();
        items = new ArrayList<>();
    }
    // CTOR - when opening a saved Store from DB
    public ARealStore(String name, String contact, List<IItem> itemList){
        storeName = name;
        contactInfo = contact;
        orders = new ArrayList<>();
        items = new ArrayList<>(itemList);
    }

    public void addItem(IItem item){
        items.add(item);
        // notify list changed (+ when notified someone will have to save to db..)
    }


    @Override
    public IVirtualStore getVirtualStore() {  // remove ????
        return store;
    }

    @Override
    public List<IItem> getItems() {
        return new ArrayList<>(items);  // give a (shallow) copy of our list
    }

    @Override
    public abstract boolean addOrder(IOrder order); // return confirmation on new order
    @Override
    public abstract String getContact();
}
