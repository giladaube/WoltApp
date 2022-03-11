package com.company.pages.abstractPages;

import com.company.pages.IPage;
import com.company.sessions.Session;

public abstract class ASearchResultsPage implements IPage {
    protected Session session;

    public ASearchResultsPage(Session session) {
        this.session = session;
    }
}
