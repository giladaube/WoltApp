package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.Session;

public abstract class ASearchStore implements IPage {
    protected Session session;

    public ASearchStore(Session session) {
        this.session = session;
    }
}
