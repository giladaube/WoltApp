package com.company.Command;

import com.company.GUI;
import com.company.pages.abstractPages.AFactoryPage;


public class ErrorCommand implements ICommand {
    private GUI gui;
    private AFactoryPage factoryPage;
    public ErrorCommand(GUI g, AFactoryPage f) {
        gui = g;
        factoryPage = f;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getErrorPage());
        gui.show();
    }
}
