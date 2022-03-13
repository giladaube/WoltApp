package com.company;

public interface IItem {
    String getItemName();
    String getItemDescription();
    float getPrice();
    // NEED TO USE DECORATOR IN ORDER TO ADD EXTRAS
    // public String[] getExtras();
}
