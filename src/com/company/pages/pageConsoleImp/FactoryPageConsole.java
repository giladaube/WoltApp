package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.*;
import com.company.sessions.ISession;
import com.company.users.UserType;
/**
 * Concrete Console Page Factory - Creates Console Pages that a GUI will present
 * @implNote these pages are interactive thus there's a need for an Obj to store User input
 * */
public class FactoryPageConsole extends AFactoryPage {
    private ISession session;

    /**
     * @param session - a Session obj to handle interaction with User through a page
     * */
    public FactoryPageConsole(ISession session){
        this.session = session;
    }

    @Override
    public AStartPage getStartPage() {
        return new StartPageConsole(session);
    }

    @Override
    public ALoginPage getLoginPage() {
        return new LoginConsolePage(session);
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
            return new MenuPageStoreConsole(session);
        }
    }

    @Override
    public ASearchStorePage getSearchStorePage() {
        return new SearchStoreConsolePage(session);
    }

    @Override
    public AOrdesPage getOrdersPage() {
        return new OrdersConsolePage(session);
    }

    @Override
    public AErrorPage getErrorPage() {
        return new ErrorPageConsole(session);
    }

    @Override
    public ASearchResultsPage getSearchResultsPage() {
        return new SearchResultsConsolePage(session);
    }

    @Override
    public AMenuViewPage getMenuViewPage() {
        return new ViewMenuPageConsole(session);
    }
    @Override
    public AMenuViewPage getSubMenuViewPage() {
        return new SubViewMenuPageConsole(session);
    }


}
