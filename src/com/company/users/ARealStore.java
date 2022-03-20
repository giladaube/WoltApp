package com.company.users;

import com.company.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

// Observed by a Virtual Store? Real Store doesn't need to know about VS presenting him (decoupling)
// maybe doesn't need to be abstract?

// After implement everything here, please go back and create new RealStore at Session class, on setUserType()
public class ARealStore extends User implements IRealStore {
    protected String storeName;
    protected String contactInfo;   // String for now, might be a class
    protected VirtualStore virtualStore;   // remove ????
    protected List<IOrder> orders;
    protected List<Item> items;    // list of items the store is selling
    protected double rating;


    // CTOR
    public ARealStore(String userName, String password, String storeName, String contact, List<Item> itemList, double rate){
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
    public IVirtualStore getVirtualStore() {  // remove ????
        return virtualStore;
    }

    @Override
    public List<IItem> getItems() {
        return new ArrayList<>(items);  // give a (shallow) copy of our list
    }


    @Override
    public synchronized boolean addOrder(IOrder order) throws InterruptedException{
        orders.add(order);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 4; i++) {
                      try {
                          sleep(1500);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      order.setStatus(i);
                  }
            }
        }).start();
        return true;
    } // return confirmation on new order

//
    @Override
    public String getContact(){
        return this.contactInfo;
    }
    @Override
    public double getRating(){return rating;}
    @Override
    public String getStoreName(){return storeName;}

    public void setVirtualStore(ARealStore realStore) {
        virtualStore = new VirtualStore(realStore);
    }
}
