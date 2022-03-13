package com.company.sessions;

import com.company.IItem;

import java.util.List;

public interface ISessionStore {
    List<IItem> getItems();
}
