package com.company.Command;

import com.company.GUI;
import com.company.UserType;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

import java.util.Map;

public class StartCommand implements ICommand {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public StartCommand(GUI g, Session s, AFactoryPage f, Map<Pages, ICommand> c) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getStartPage());
        gui.show();
        try {
            if (Pages.values()[session.getMenuSelection()] == Pages.EXIT) {
                commands.get(Pages.EXIT).execute();
            }
            switch (UserType.values()[session.getMenuSelection()]){
                case CUSTOMER -> {
                    session.setUserType(UserType.CUSTOMER);
                    commands.get(Pages.LOGIN).execute();
                }
                case STORE -> {
                    session.setUserType(UserType.STORE);
                    commands.get(Pages.LOGIN).execute();
                }
            }
        } catch (Exception e) {
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}
