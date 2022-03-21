package com.company.orders.items;

public class RegularPizza extends Pizza {

    public RegularPizza() {
        description = "Regular Pizza";
    }

    public double getPrice() {
        return 40;
    }
}