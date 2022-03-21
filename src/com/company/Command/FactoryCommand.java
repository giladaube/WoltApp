package com.company.Command;

import com.company.db.FileDB;
import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;

public class FactoryCommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private IDatabase db;
    public FactoryCommand(GUI g, ISession s, AFactoryPage f) {
        gui = g;
        session = s;
        factoryPage = f;
        db = FileDB.getDatabase();
    }

    public ICommand getStartCommand(Map<Pages, ICommand> commands){
        return new StartCommand(gui, session, factoryPage, commands);
    }

    public ICommand getLoginCommand(Map<Pages, ICommand> commands){
        return new LoginCommand(gui, session, factoryPage, commands);
    }

    public ICommand getSignInCommand(Map<Pages, ICommand> commands){
        return new SignInCommand(gui, session, factoryPage, commands, db);
    }

    public ICommand getSignUpCommand(Map<Pages, ICommand> commands){
        return new SignUpCommand(gui, session, factoryPage, commands, db);
    }

    public ICommand getMainMenuCommand(Map<Pages, ICommand> commands) {
        return new MainMenuCommand(gui, session, factoryPage, commands, db, this);
    }

    public ICommand getExitCommand() {
        return new ExitCommand();
    }

    public ICommand getErrorCommand(Map<Pages, ICommand> commands) {
        return new ErrorCommand(gui, session, factoryPage, commands);
    }

    public ICommand gerCustomerMenuCommand(Map<Pages, ICommand> commands) {
        return new CustomerMenuCommand(gui, session, factoryPage, commands);
    }

    public ICommand getSearchStoresBy(Map<Pages, ICommand> commands) {
        return new SearchStoreCommand(gui, session, factoryPage, commands, db);
    }

    public ICommand getSearchResults(Map<Pages, ICommand> commands) {
        return new SearchResultsCommand(gui, session, factoryPage, commands, db);
    }

    public ICommand getOrders(Map<Pages, ICommand> commands) {
        return new OrdersCommand(gui, session, factoryPage, commands, db);
    }

    public ICommand getStoreMenuCommand(Map<Pages, ICommand> commands) {
        return new StoreMenuCommand(gui, session, factoryPage, commands);
    }
    public ICommand getMenuViewCommand(Map<Pages, ICommand> commands) {
        return new ViewMenuCommand(gui, session, factoryPage, commands, db);
    }
}
