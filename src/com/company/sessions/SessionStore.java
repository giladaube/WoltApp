package com.company.sessions;

import com.company.orders.IItem;
import com.company.users.IRealStore;

import java.util.List;

public class SessionStore implements ISessionStore{
    private IRealStore realStore;

    public SessionStore(IRealStore r) {
        realStore = r;
    }
    @Override
    public List<IItem> getItems() {
        return realStore.getItems();
    }
}
