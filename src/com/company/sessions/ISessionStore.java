package com.company.sessions;

import com.company.orders.IItem;

import java.util.List;

public interface ISessionStore {
    List<IItem> getItems();
}
