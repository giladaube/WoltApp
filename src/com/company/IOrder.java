package com.company;

import java.util.List;

public interface IOrder {
    public List<IItem> getItems();
    public IVirtualStore getStore();
    public float getPrice();
}
