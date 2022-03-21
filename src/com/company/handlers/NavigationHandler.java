package com.company.handlers;

import com.company.Command.*;
import com.company.db.FileDB;
import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.HashMap;
import java.util.Map;

public class NavigationHandler implements INavigation{
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private IDatabase db;
    private FactoryCommand factoryCommand;
    private Map<Pages, ICommand> commands;
    public NavigationHandler(GUI g, ISession s, AFactoryPage f, FactoryCommand fc) {
        gui = g;
        session = s;
        factoryPage = f;
        db = FileDB.getDatabase();
        factoryCommand = fc;
        initCommands();
    }

    private void initCommands() {
        commands = new HashMap<>();
        commands.put(Pages.START, factoryCommand.getStartCommand(commands));
        commands.put(Pages.LOGIN, factoryCommand.getLoginCommand(commands));
        commands.put(Pages.SIGN_IN, factoryCommand.getSignInCommand(commands));
        commands.put(Pages.SIGN_UP, factoryCommand.getSignUpCommand(commands));
        commands.put(Pages.MAIN_MENU, factoryCommand.getMainMenuCommand(commands));
        commands.put(Pages.EXIT, factoryCommand.getExitCommand());
        commands.put(Pages.ERROR, factoryCommand.getErrorCommand(commands));
    }

    @Override
    public void start() {
        commands.get(Pages.START).execute();
    }
}
