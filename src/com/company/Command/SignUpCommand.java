package com.company.Command;

import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;
import com.company.users.User;

import java.util.Map;

public class SignUpCommand implements ICommand {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;
    public SignUpCommand(GUI g, Session s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
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
            User user = db.checkUserExists(session.getUserName(), session.getTempPassword());
            if(user != null){
                // session.setUser();
                commands.get(Pages.MAIN_MENU).execute();
            }
            else
                commands.get(Pages.REDIRECT).execute();
        } catch (Exception e) {
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}