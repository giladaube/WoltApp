package com.company.handlers;

import com.company.ConsoleGUI;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

public class NavigationHandler {
    private ConsoleGUI consoleGui;
    private Session session;
    private AFactoryPage factoryPage;

    public NavigationHandler(ConsoleGUI g, Session s, AFactoryPage f) {
        consoleGui = g;
        session = s;
        factoryPage = f;
    }

    private void login() {
        LoginHandler loginHandler = new LoginHandler(factoryPage, consoleGui, session);
        loginHandler.start();
    }

    private int menu() {
        consoleGui.setPage(factoryPage.getMenuPage());
        consoleGui.show();
        return session.getMenuSelection();
    }

    public void start() {
        login();
        int userSelection = menu();
        while (userSelection != 3) {
            // NEED TO USE A COMMAND PATTERN HERE, WHICH WILL RETURN A PAGE BASED ON USER SELECTION
            System.out.println("user selection is:" + userSelection);
            userSelection = menu();
        }
    }

}
