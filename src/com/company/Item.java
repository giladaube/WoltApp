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
        return name;
    }

    @Override
    public String getItemDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
