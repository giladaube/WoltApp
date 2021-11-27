package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISessionLogin;

public abstract class ASignInPage implements IPage {
    protected ISessionLogin session;

    public ASignInPage(ISessionLogin s){
        session = s;
    }
}
