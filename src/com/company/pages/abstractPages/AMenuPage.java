package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISessionMenu;
import com.company.sessions.Session;

public abstract class AMenuPage implements IPage {
    protected Session session;

    public AMenuPage(Session s){
        session = s;
    }
}
