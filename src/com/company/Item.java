package com.company;


public class Item implements IItem {
    private String name;
    private String description;
    private double price;
    public Item(String name, String description, double price){
        this.name=name;
        this.description=description;
        this.price=price;
    }
    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public String getItemDescription() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
