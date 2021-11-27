package com.company.handlers;

import com.company.GUI;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

public class NavigationHandler {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;

    public NavigationHandler(GUI g, Session s, AFactoryPage f) {
        gui = g;
        session = s;
        factoryPage = f;
    }

    private void login() {
        LoginHandler loginHandler = new LoginHandler(factoryPage, gui, session);
        loginHandler.start();
    }

    private int menu() {
        gui.setPage(factoryPage.getMenuPage());
        gui.show();
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
