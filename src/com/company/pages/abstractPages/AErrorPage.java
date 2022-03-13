package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class AErrorPage implements IPage {
    protected ISession session;
    public AErrorPage(ISession session){this.session = session; session.setPermissions(this);}
}
