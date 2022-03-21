package com.company.Command;

import com.company.pages.GUI;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.pages.Pages;
import com.company.sessions.ISession;

import java.util.Map;

public class LoginCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public LoginCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getLoginPage());
        gui.show();
        try {
            session.setPermissions(this);
            switch (Pages.values()[session.getMenuSelection()]) {
                case START -> commands.get(Pages.START).execute();
                case SIGN_IN -> commands.get(Pages.SIGN_IN).execute();
                case SIGN_UP -> commands.get(Pages.SIGN_UP).execute();
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