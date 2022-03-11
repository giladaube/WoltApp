package com.company.handlers;

import com.company.Command.*;
import com.company.FileDB;
import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

import java.util.HashMap;
import java.util.Map;

public class NavigationHandler {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private IDatabase db;
    private Map<Pages, ICommand> commands;
    public NavigationHandler(GUI g, Session s, AFactoryPage f) {
        gui = g;
        session = s;
        factoryPage = f;
        db = FileDB.getDatabase();
        initCommands();
    }

    private void initCommands() {
        commands = new HashMap<>();
        commands.put(Pages.START, new StartCommand(gui, session, factoryPage, commands));
        commands.put(Pages.LOGIN, new LoginCommand(gui, session, factoryPage, commands));
        commands.put(Pages.SIGN_IN, new SignInCommand(gui, session, factoryPage, commands, db));
        commands.put(Pages.SIGN_UP, new SignUpCommand(gui, session, factoryPage, commands, db));
        commands.put(Pages.REDIRECT, new RedirectCommand(gui, session, factoryPage, commands));
        commands.put(Pages.MAIN_MENU, new MainMenuCommand(gui, session, factoryPage, commands, db));
        commands.put(Pages.EXIT, new ExitCommand(gui, session, factoryPage, commands));
        commands.put(Pages.ERROR, new ErrorCommand(gui, factoryPage));
    }

    public void start() {
        commands.get(Pages.START).execute();
    }
}
