package com.company.handlers;

import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

public class StoreNavigationHandler {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Pages curPage;
    private boolean run;
    private IDatabase db;
    public StoreNavigationHandler(GUI gui, Session session, AFactoryPage factoryPage, IDatabase db) {
        this.gui = gui;
        this.session = session;
        this.factoryPage = factoryPage;
        this.curPage = Pages.MAIN_MENU;
        this.run = true;
        this.db = db;
    }

    public void start() {
        while(run){

        }
    }
}
