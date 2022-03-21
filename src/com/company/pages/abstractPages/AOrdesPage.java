package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class AOrdesPage implements IPage {
    protected ISession session;
    public AOrdesPage(ISession session){this.session = session; session.setPermissions(this);}
}
