package com.company.pages;

import com.company.pages.abstractPages.AMenuPage;

public interface IFactoryPageNavigation {
    public AMenuPage getMenuPage();
    public IPage getSelectedPage();
}
