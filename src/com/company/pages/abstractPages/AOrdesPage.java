package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.Session;

public abstract class AOrdesPage implements IPage {
    protected Session session;
    public AOrdesPage(Session session){this.session = session;}
}
