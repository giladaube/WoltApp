package com.company.Command;

import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;

public class SearchResultsCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;
    public SearchResultsCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
        db = d;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getSearchResultsPage());
        gui.show();
        try {
            session.setPermissions(this);
            switch(Pages.values()[session.getMenuSelection()]){
                case VIEW_MENU -> commands.get(Pages.VIEW_MENU).execute();
                case MAIN_MENU -> commands.get(Pages.MAIN_MENU).execute();
                case SEARCH_STORES_BY -> commands.get(Pages.SEARCH_STORES_BY).execute();
                default -> {
                    session.setErrorMessage("Wrong input");
                    commands.get(Pages.ERROR).execute();
                    execute();
                }
            }
        } catch (Exception e) {
            session.setErrorMessage(e.getMessage());
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}
