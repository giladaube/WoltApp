package com.company.orders.items;

abstract class Pizza extends ComplexItem {

    String description = "Pizza";

    abstract public double getPrice();

    public String getItemDescription()
    {
        return description;
    }
}
