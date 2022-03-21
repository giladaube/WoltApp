package com.company.Command;

import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.users.UserType;
import com.company.handlers.CustomerNavigationHandler;
import com.company.handlers.StoreNavigationHandler;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;

public class MainMenuCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;
    private FactoryCommand factoryCommand;
    public MainMenuCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d, FactoryCommand fc) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
        db = d;
        factoryCommand = fc;
    }
    @Override
    public void execute() {
        session.setPermissions(this);
        if(session.getUserType() == UserType.CUSTOMER)
            (new CustomerNavigationHandler(gui, session, factoryPage, db, factoryCommand)).start();
        else
            (new StoreNavigationHandler(gui, session, factoryPage, db, factoryCommand)).start();
    }
}