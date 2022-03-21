package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class ASearchStorePage implements IPage {
    protected ISession session;

    public ASearchStorePage(ISession session) {
        this.session = session;
        session.setPermissions(this);
    }
}
