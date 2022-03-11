package com.company.Command;

import com.company.GUI;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.pages.Pages;
import com.company.sessions.Session;

import java.util.Map;

public class LoginCommand implements ICommand {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public LoginCommand(GUI g, Session s, AFactoryPage f, Map<Pages, ICommand> c) {
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
            switch (Pages.values()[session.getMenuSelection()]) {
                case START -> commands.get(Pages.START).execute();
                case SIGN_IN -> commands.get(Pages.SIGN_IN).execute();
                case SIGN_UP -> commands.get(Pages.SIGN_UP).execute();
            }
        } catch (Exception e) {
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}