package com.company.Command;

import com.company.GUI;
import com.company.IDatabase;
import com.company.UserType;
import com.company.handlers.CustomerNavigationHandler;
import com.company.handlers.StoreNavigationHandler;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;
import com.company.users.User;

import java.util.Map;

public class MainMenuCommand implements ICommand {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;
    public MainMenuCommand(GUI g, Session s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
        db = d;
    }
    @Override
    public void execute() {
        if(session.getUserType() == UserType.CUSTOMER)
            (new CustomerNavigationHandler(gui, session, factoryPage, db)).start();
        else
            (new StoreNavigationHandler(gui, session, factoryPage, db)).start();
    }
}