package com.company.handlers;

import com.company.Command.*;
import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

import java.util.HashMap;
import java.util.Map;

public class StoreNavigationHandler {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private IDatabase db;
    private Map<Pages, ICommand> commands;
    public StoreNavigationHandler(GUI gui, Session session, AFactoryPage factoryPage, IDatabase db) {
        this.gui = gui;
        this.session = session;
        this.factoryPage = factoryPage;
        this.db = db;
        initCommands();
    }

    private void initCommands() {
        commands = new HashMap<>();
    }

    public void start() {

    }
}
