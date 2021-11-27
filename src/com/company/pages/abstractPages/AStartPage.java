package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISessionLogin;

public abstract class AStartPage implements IPage {
    protected ISessionLogin session;

    public AStartPage(ISessionLogin s) {
        session = s;
    }
}
