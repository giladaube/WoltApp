package com.company.pages.abstractPages;

import com.company.pages.IFactoryPageLogin;
import com.company.pages.IFactoryPageNavigation;
import com.company.pages.IPage;
import com.company.pages.Pages;
/**
 * Abstract Page Factory -
 * Derived Factories will implement different ways of implementing a concrete Page
 * */
public abstract class AFactoryPage {
    public abstract AStartPage getStartPage();
    public abstract ALoginPage getLoginPage();
    public abstract ASignUpPage getSignUpPage();
    public abstract ASignInPage getSignInPage();
    public abstract ARedirectionPage getRedirectionPage();
    public abstract AMenuPage getMenuPage();
    public abstract ASearchStore getSearchStorePage();
    public abstract AOrdesPage getOrdersPage();

}
