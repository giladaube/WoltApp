package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class ALoginPage implements IPage {
    protected ISession session;
    public ALoginPage(ISession session){this.session = session; session.setPermissions(this);}
}
