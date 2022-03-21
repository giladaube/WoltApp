package com.company.Command;

import com.company.pages.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;

public class StoreMenuCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public StoreMenuCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c) {
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