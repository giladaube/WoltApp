package com.company.Command;

import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;
import com.company.users.User;

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
                // add given input to DB, get in return userId.
                session.setUserId(1234);
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