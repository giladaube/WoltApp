package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.ISessionMenu;

public abstract class AMenuPage implements IPage {
    protected ISessionMenu session;

    public AMenuPage(ISessionMenu s){
        session = s;
    }
}
