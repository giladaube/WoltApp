package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISession;

public abstract class AMenuViewPage implements IPage {
    protected ISession session;
    public AMenuViewPage(ISession session){this.session = session; session.setPermissions(this);}
}
