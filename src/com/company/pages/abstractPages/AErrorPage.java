package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.Session;

public abstract class AErrorPage implements IPage {
    protected Session session;
    public AErrorPage(Session session){this.session = session;}
}
