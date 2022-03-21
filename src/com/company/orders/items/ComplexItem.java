package com.company.orders.items;

import com.company.orders.IItem;

abstract class ComplexItem implements IItem {

    private String name;
    private String description;

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public String getItemDescription() {
        return description;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name            ").append(name).append("\n");
        result.append("Description     ").append(description).append("\n");
        return result.toString();
    }
}
