package com.company.Command;

import com.company.pages.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;


public class ErrorCommand implements ICommand {
    private GUI gui;
    private AFactoryPage factoryPage;
    private ISession session;
    private Map<Pages, ICommand> commands;
    public ErrorCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getErrorPage());
        gui.show();
        try {
            session.setPermissions(this);
            if (session.getMenuSelection() == 1) {
                return;
            }
            switch (Pages.values()[session.getMenuSelection()]) {
                case START -> commands.get(Pages.START).execute();
                case MAIN_MENU -> commands.get(Pages.MAIN_MENU).execute();
                case EXIT -> commands.get(Pages.EXIT).execute();
                default -> {
                    session.setErrorMessage("Wrong input");
                    commands.get(Pages.ERROR).execute();
                    execute();
                }
            }
        } catch (Exception e) {
            System.out.printf("An Error accrued: %s", e.getMessage());
            commands.get(Pages.EXIT).execute();
        }
    }
}
