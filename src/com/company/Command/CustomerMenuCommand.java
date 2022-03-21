package com.company.Command;

import com.company.pages.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;

public class CustomerMenuCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public CustomerMenuCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getMenuPage());
        gui.show();
        try {
            session.setPermissions(this);
            switch (Pages.values()[session.getMenuSelection()]) {
                case SEARCH_STORES_BY -> commands.get(Pages.SEARCH_STORES_BY).execute();
                case ORDERS -> commands.get(Pages.ORDERS).execute();
                case EXIT -> commands.get(Pages.EXIT).execute();
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