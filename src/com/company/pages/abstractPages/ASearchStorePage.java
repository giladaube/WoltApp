package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.Session;

public abstract class ASearchStorePage implements IPage {
    protected Session session;

    public ASearchStorePage(Session session) {
        this.session = session;
    }
}
