package com.company.Command;

import com.company.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;
import java.util.Map;

public class CustomerMenuCommand implements ICommand {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public CustomerMenuCommand(GUI g, Session s, AFactoryPage f, Map<Pages, ICommand> c) {
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
            if (Pages.values()[session.getMenuSelection()] == Pages.MAIN_MENU) {
                commands.get(Pages.MAIN_MENU).execute();
            }
            switch (Pages.values()[session.getMenuSelection()]) {
                case SEARCH_STORES_BY -> commands.get(Pages.SEARCH_STORES_BY).execute();
                case ORDERS -> commands.get(Pages.ORDERS).execute();
            }
        } catch (Exception e) {
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}