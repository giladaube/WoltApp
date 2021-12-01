package com.company.handlers;

import com.company.GUI;
import com.company.pages.IFactoryPageLogin;
import com.company.sessions.ISessionLogin;

public class LoginHandler {
    private IFactoryPageLogin factory;
    private GUI gui;
    private ISessionLogin sessionLogin;

    public LoginHandler(IFactoryPageLogin f, GUI g, ISessionLogin sg) {
        factory = f;
        gui = g;
        sessionLogin = sg;
    }

    public void start(){
        gui.setPage(factory.getStartPage());
        gui.show();

        if(sessionLogin.isSignup()) {
            gui.setPage(factory.getSignUpPage());
        } else {
            gui.setPage(factory.getSignInPage());
        }
        gui.show();
    }

}
