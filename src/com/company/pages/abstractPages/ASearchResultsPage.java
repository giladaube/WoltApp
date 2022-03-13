package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class ASearchResultsPage implements IPage {
    protected ISession session;

    public ASearchResultsPage(ISession session) {
        this.session = session;
        session.setPermissions(this);
    }
}
