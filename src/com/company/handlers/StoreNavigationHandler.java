package com.company.handlers;

import com.company.Command.*;
import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.HashMap;
import java.util.Map;

public class StoreNavigationHandler implements INavigation {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private IDatabase db;
    private Map<Pages, ICommand> commands;
    private FactoryCommand factoryCommand;
    public StoreNavigationHandler(GUI gui, ISession session, AFactoryPage factoryPage, IDatabase db, FactoryCommand fc) {
        this.gui = gui;
        this.session = session;
        this.factoryPage = factoryPage;
        this.db = db;
        factoryCommand = fc;
        initCommands();
    }

    private void initCommands() {
        commands = new HashMap<>();
        commands.put(Pages.START, factoryCommand.getStoreMenuCommand(commands));
        commands.put(Pages.MAIN_MENU, factoryCommand.getStoreMenuCommand(commands));
        commands.put(Pages.EXIT, factoryCommand.getExitCommand());
        commands.put(Pages.ERROR, factoryCommand.getErrorCommand(commands));
    }

    @Override
    public void start() {
        commands.get(Pages.MAIN_MENU).execute();
    }
}
