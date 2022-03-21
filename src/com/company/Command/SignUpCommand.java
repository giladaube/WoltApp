package com.company.Command;

import com.company.db.IDatabase;
import com.company.orders.Item;
import com.company.pages.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;
import com.company.users.RealStore;
import com.company.users.Customer;
import com.company.users.User;
import com.company.users.UserType;

import java.util.ArrayList;
import java.util.Map;

public class SignUpCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;
    public SignUpCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
        db = d;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getSignUpPage());
        gui.show();
        try {
            session.setPermissions(this);
            User user = db.checkUserExists(session.getUserName(), session.getTempPassword());
            if (user == null) {
                User aUser;
                if(session.getUserType() == UserType.CUSTOMER)
                    aUser = new Customer(session.getUserName(), session.getTempPassword());
                else
                    aUser = new RealStore("king","123", "Some new Store", "Don't call us, we call you", new ArrayList<>(){
                        {
                            add(new Item("some new Item","yum yum", 10));
                        }
                    }, 4.5); // we need a page for Store sign-up. for now, we add manually
                db.saveUser(aUser);
                session.setUser(aUser);
                commands.get(Pages.MAIN_MENU).execute();
            } else {
                session.setErrorMessage("This user is already exist");
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