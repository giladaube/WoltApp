package com.company;

import com.company.handlers.NavigationHandler;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.pages.pageConsoleImp.FactoryPageConsole;
import com.company.sessions.Session;
import com.company.users.ARealStore;
import com.company.users.User;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        User user = new User();
        Session session = new Session(user);
        AFactoryPage factory = new FactoryPageConsole(session);
        NavigationHandler navigationHandler = new NavigationHandler(gui, session, factory);
        navigationHandler.start();

    }
}
