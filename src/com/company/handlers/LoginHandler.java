package com.company.handlers;

import com.company.ConsoleGUI;
import com.company.pages.IFactoryPageLogin;
import com.company.sessions.ISessionLogin;

public class LoginHandler {
    private IFactoryPageLogin factory;
    private ConsoleGUI consoleGui;
    private ISessionLogin sessionLogin;

    public LoginHandler(IFactoryPageLogin f, ConsoleGUI g, ISessionLogin sg) {
        factory = f;
        consoleGui = g;
        sessionLogin = sg;
    }

    public void start(){
        consoleGui.setPage(factory.getStartPage());
        consoleGui.show();

        if(sessionLogin.isSignup()) {
            consoleGui.setPage(factory.getSignUpPage());
        } else {
            consoleGui.setPage(factory.getSignInPage());
        }
        consoleGui.show();
    }

}
