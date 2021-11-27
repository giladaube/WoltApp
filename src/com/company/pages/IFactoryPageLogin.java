package com.company.pages;

import com.company.pages.abstractPages.ASignInPage;
import com.company.pages.abstractPages.ASignUpPage;
import com.company.pages.abstractPages.AStartPage;

public interface IFactoryPageLogin {
    public AStartPage getStartPage();
    public ASignUpPage getSignUpPage();
    public ASignInPage getSignInPage();

}
