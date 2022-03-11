package com.company.handlers;

import com.company.Command.*;
import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

import java.util.HashMap;
import java.util.Map;

public class CustomerNavigationHandler {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private IDatabase db;
    private Map<Pages, ICommand> commands;
    public CustomerNavigationHandler(GUI gui, Session session, AFactoryPage factoryPage, IDatabase db) {
        this.gui = gui;
        this.session = session;
        this.factoryPage = factoryPage;
        this.db = db;
        initCommands();
    }

    private void initCommands() {
        commands = new HashMap<>();
        commands.put(Pages.MAIN_MENU, new CustomerMenuCommand(gui, session, factoryPage, commands));
        commands.put(Pages.SEARCH_STORES_BY, new SearchStoreCommand(gui, session, factoryPage, commands));
        commands.put(Pages.SEARCH_RESULTS, new SearchResultsCommand(gui, session, factoryPage, commands, db));
        commands.put(Pages.ORDERS, new OrdersCommand(gui, session, factoryPage, commands, db));
        commands.put(Pages.EXIT, new ExitCommand(gui, session, factoryPage, commands));
        commands.put(Pages.ERROR, new ErrorCommand(gui, factoryPage));
    }

    public void start() {
        commands.get(Pages.MAIN_MENU).execute();
    }
}
