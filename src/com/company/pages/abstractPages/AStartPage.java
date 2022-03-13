package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class AStartPage implements IPage {
    protected ISession session;

    public AStartPage(ISession s) {
        session = s;
        session.setPermissions(this);
    }
}
