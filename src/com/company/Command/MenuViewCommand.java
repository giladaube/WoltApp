package com.company.Command;

import com.company.*;
import com.company.pages.Pages;
import com.company.pages.Search;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;
import com.company.users.ARealStore;
import com.company.users.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuViewCommand implements ICommand{
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;

    public MenuViewCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
        db = d;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getMenuViewPage());
        gui.show();
        try {
            session.setPermissions(this);
//            if (Pages.values()[session.getMenuSelection()] == Pages.MAIN_MENU) {
//                commands.get(Pages.MAIN_MENU).execute();
//            }
            int i = session.getMenuSelection();
            IItem anItem = session.getPickedStore().getItems().get(i);
//            new Order();
            switch (Search.values()[session.getMenuSelection()]) {

            }
            Customer c = (Customer)session.getUser();
            List<IItem> pickedItems = new ArrayList<>(){
                {
                    add(new Item("Texas's choice", "200g burger", 60));
                    add(new Item("Big One", "300g burger", 70));
                    add(new Item("Vegan burger", "vegan burger", 50));
                }
            };
            c.addOrder(pickedItems, session.getPickedStore());
            System.out.println("AFTER ADD ORDER");
            commands.get(Pages.MAIN_MENU).execute();
        } catch (Exception e) {
            session.setErrorMessage(e.getMessage());
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}
