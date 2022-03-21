package com.company.Command;

import com.company.db.IDatabase;
import com.company.orders.IItem;
import com.company.pages.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;
import com.company.users.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewMenuCommand implements ICommand{
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;

    public ViewMenuCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
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
            int i = session.getMenuSelection();
            List<IItem> storeItems = session.getPickedStore().getItems();
            List<IItem> pickedItems = new ArrayList<>();
            while(i != storeItems.size() && i != storeItems.size()+1){
                pickedItems.add(storeItems.get(i));
                gui.setPage(factoryPage.getSubMenuViewPage());  // added such that we can grab multi items
                gui.show();
                session.setPermissions(this);
                i = session.getMenuSelection();
            }
            if(i == storeItems.size()) {  // user entered DONE option -> send order and then back to main menu
                Customer c = (Customer)session.getUser(); // we know for a fact that this user is customer
                c.addOrder(pickedItems, session.getPickedStore());
            }
            commands.get(Pages.MAIN_MENU).execute();
        } catch (Exception e) {
            session.setErrorMessage(e.getMessage());
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}
