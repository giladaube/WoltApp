package com.company.sessions;

public class SessionMenu implements ISessionMenu{
    private int menuSelection;

    @Override
    public void setMenuSelection(int s) {
        menuSelection = s;
    }

    @Override
    public int getMenuSelection() {
        return menuSelection;
    }
}
