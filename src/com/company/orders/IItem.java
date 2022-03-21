package com.company.orders;

public interface IItem {
    String getItemName();
    String getItemDescription();
    double getPrice();
//     NEED TO USE DECORATOR IN ORDER TO ADD EXTRAS
//     public String[] getExtras();
}
