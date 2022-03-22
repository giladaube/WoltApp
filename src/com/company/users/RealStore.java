package com.company.users;

import com.company.orders.IItem;
import com.company.orders.IOrder;
import com.company.orders.Item;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class RealStore extends User implements IRealStore {
    protected String storeName;
    protected String contactInfo;
    protected VirtualStore virtualStore;
    protected List<IOrder> orders;
    protected List<Item> items;    // list of items the store is selling
    protected double rating;


    // CTOR
    public RealStore(String userName, String password, String storeName, String contact, List<Item> itemList, double rate){
        super(userName, password, UserType.STORE, Location.generateRandomLocation());
        this.storeName = storeName;
        contactInfo = contact;
        orders = new ArrayList<>();
        items = new ArrayList<>(itemList);
        rating = rate;

    }

    public void addItem(Item item){
        items.add(item);
        // notify list changed (+ when notified someone will have to save to db..)
    }

    @Override
    public IVirtualStore getVirtualStore() {
        return virtualStore;
    }

    @Override
    public List<IItem> getItems() {
        return new ArrayList<>(items);  // give a (shallow) copy of our list
    }

    @Override
    public boolean addOrder(IOrder order) throws InterruptedException{
        orders.add(order);
        new Thread(() -> {
            for (int i = 1; i < 4; i++) {
                  try {
                      sleep(2500);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  order.setStatus(i);
              }
        }).start();
        return true;
    } // return confirmation on new order

    @Override
    public String getContact(){
        return this.contactInfo;
    }
    @Override
    public double getRating(){return rating;}
    @Override
    public String getStoreName(){return storeName;}

    public void setVirtualStore(RealStore realStore) {
        virtualStore = new VirtualStore(realStore);
    }
}
