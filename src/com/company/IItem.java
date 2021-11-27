package com.company;

public interface IItem {
    public String getItemName();
    public String getItemDescription();
    public float getPrice();
    // NEED TO USE DECORATOR IN ORDER TO ADD EXTRAS
    // public String[] getExtras();
}
