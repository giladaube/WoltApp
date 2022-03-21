package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class ASignUpPage implements IPage {
    protected ISession session;

    public ASignUpPage(ISession s){
        session = s;
        session.setPermissions(this);
    }

}
