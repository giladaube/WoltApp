package com.company.orders;


public class Item implements IItem {
    private String name;
    private String description;
    private double price;

    public Item(String name, String description, double price){
        this.name=name;
        this.description=description;
        this.price=price;
    } @Override
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name            ").append(name).append("\n");
        result.append("Description     ").append(description).append("\n");
        result.append("Price           ").append(price).append("\n");
        return result.toString();

    }
}
