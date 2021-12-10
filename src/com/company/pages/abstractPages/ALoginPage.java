package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.Session;

public abstract class ALoginPage implements IPage {
    protected Session session;
    public ALoginPage(Session session){this.session = session;}
}
