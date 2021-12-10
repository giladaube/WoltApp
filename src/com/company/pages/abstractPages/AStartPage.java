package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISessionLogin;
import com.company.sessions.Session;

public abstract class AStartPage implements IPage {
    protected Session session;

    public AStartPage(Session s) {
        session = s;
    }
}
