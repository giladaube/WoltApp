package com.company.pages.abstractPages;

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
    public abstract ASearchStorePage getSearchStorePage();
    public abstract AOrdesPage getOrdersPage();
    public abstract AErrorPage getErrorPage();
    public abstract ASearchResultsPage getSearchResultsPage();

}
