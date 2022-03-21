package com.company.Command;

import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;

import java.util.Map;

public class OrdersCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;
    public OrdersCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
        db = d;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getOrdersPage());
        gui.show();
        try {
            session.setPermissions(this);
            if (Pages.values()[session.getMenuSelection()] == Pages.MAIN_MENU) {
                commands.get(Pages.MAIN_MENU).execute();
            } else {
                session.setErrorMessage("Wrong input");
                commands.get(Pages.ERROR).execute();
                execute();
            }
        } catch (Exception e) {
            session.setErrorMessage(e.getMessage());
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}