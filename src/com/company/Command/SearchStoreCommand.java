package com.company.Command;

import com.company.GUI;
import com.company.pages.Pages;
import com.company.pages.Search;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;

public class SearchStoreCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public SearchStoreCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getSearchStorePage());
        gui.show();
        try {
            session.setPermissions(this);
            if (Pages.values()[session.getMenuSelection()] == Pages.MAIN_MENU) {
                commands.get(Pages.MAIN_MENU).execute();
            }
            switch (Search.values()[session.getMenuSelection()]) {
                case DISTANCE -> {
                    //inject strategy sort by Distance
                }
                case RATING -> {
                    //inject strategy sort by Rating
                }
            }
            commands.get(Pages.SEARCH_RESULTS).execute();
        } catch (Exception e) {
            session.setErrorMessage(e.getMessage());
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}