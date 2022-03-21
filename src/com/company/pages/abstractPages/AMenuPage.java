package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class AMenuPage implements IPage {
    protected ISession session;

    public AMenuPage(ISession s){
        session = s;
        session.setPermissions(this);
    }
}
