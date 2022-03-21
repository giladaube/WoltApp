package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class ASignInPage implements IPage {
    protected ISession session;

    public ASignInPage(ISession s){
        session = s;
        session.setPermissions(this);
    }
}
