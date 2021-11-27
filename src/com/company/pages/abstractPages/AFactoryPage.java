package com.company.pages.abstractPages;

import com.company.pages.IFactoryPageLogin;
import com.company.pages.IFactoryPageNavigation;
import com.company.pages.IPage;

public abstract class AFactoryPage implements IFactoryPageLogin, IFactoryPageNavigation {
    @Override
    public abstract AStartPage getStartPage();
    @Override
    public abstract ASignUpPage getSignUpPage();
    @Override
    public abstract ASignInPage getSignInPage();
    @Override
    public abstract AMenuPage getMenuPage();
    @Override
    public abstract IPage getSelectedPage();
}
