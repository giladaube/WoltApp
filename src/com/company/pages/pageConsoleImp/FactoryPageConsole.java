package com.company.pages.pageConsoleImp;

import com.company.pages.*;
import com.company.pages.abstractPages.*;
import com.company.sessions.Session;
import com.company.UserType;

public class FactoryPageConsole extends AFactoryPage {
    private Session session;

    public FactoryPageConsole(Session s){
        this.session = s;
    }

    @Override
    public AStartPage getStartPage() {
        return new StartPageConsole(session);
    }

    @Override
    public ASignUpPage getSignUpPage(){
        return new SignUpPageConsole(session);
    }

    @Override
    public ASignInPage getSignInPage(){
        return new SignInPageConsole(session);
    }

    @Override
    public AMenuPage getMenuPage() {
        UserType type = session.getUserType();
        if (type.equals(UserType.CUSTOMER)) {
            return new MenuPageCustomerConsole(session);
        } else {
            return new MenuPageSupplierConsole(session);
        }
    }

    // NEED TO BE COMMAND
    @Override
    public IPage getSelectedPage() {
        return null;
    }
}
