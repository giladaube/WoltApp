package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISessionLogin;

public abstract class ASignUpPage implements IPage {
    protected ISessionLogin session;

    public ASignUpPage(ISessionLogin s){
        session = s;
    }

}
