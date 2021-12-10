package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISessionLogin;
import com.company.sessions.Session;

public abstract class ASignInPage implements IPage {
    protected Session session;

    public ASignInPage(Session s){
        session = s;
    }
}
