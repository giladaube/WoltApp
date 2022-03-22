package com.company;

import com.company.Command.FactoryCommand;
import com.company.handlers.INavigation;
import com.company.handlers.NavigationHandler;
import com.company.pages.GUI;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.pages.pageConsoleImp.FactoryPageConsole;
import com.company.sessions.ISession;
import com.company.sessions.SessionProxy;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        ISession session = new SessionProxy();
        AFactoryPage factory = new FactoryPageConsole(session);
        FactoryCommand factoryCommand = new FactoryCommand(gui, session, factory);
        INavigation navigationHandler = new NavigationHandler(gui, session, factory, factoryCommand);
        navigationHandler.start();

    }
}
