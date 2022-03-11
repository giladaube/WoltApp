package com.company.Command;

import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

import java.util.Map;

public class OrdersCommand implements ICommand {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;
    public OrdersCommand(GUI g, Session s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
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
            if (Pages.values()[session.getMenuSelection()] == Pages.MAIN_MENU) {
                commands.get(Pages.MAIN_MENU).execute();
            }
        } catch (Exception e) {
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}