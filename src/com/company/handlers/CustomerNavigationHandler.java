package com.company.handlers;

import com.company.Command.*;
import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.HashMap;
import java.util.Map;

public class CustomerNavigationHandler implements INavigation {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private IDatabase db;
    private Map<Pages, ICommand> commands;
    private FactoryCommand factoryCommand;
    public CustomerNavigationHandler(GUI gui, ISession session, AFactoryPage factoryPage, IDatabase db, FactoryCommand fc) {
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
        commands.put(Pages.MAIN_MENU, factoryCommand.gerCustomerMenuCommand(commands));
        commands.put(Pages.SEARCH_STORES_BY, factoryCommand.getSearchStoresBy(commands));
        commands.put(Pages.SEARCH_RESULTS, factoryCommand.getSearchResults(commands));
        commands.put(Pages.ORDERS, factoryCommand.getOrders(commands));
        commands.put(Pages.EXIT, factoryCommand.getExitCommand());
        commands.put(Pages.ERROR, factoryCommand.getErrorCommand(commands));
        commands.put(Pages.VIEW_MENU, factoryCommand.getMenuViewCommand(commands));
    }

    @Override
    public void start() {
        commands.get(Pages.MAIN_MENU).execute();
    }
}
