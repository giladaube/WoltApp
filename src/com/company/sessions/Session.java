package com.company.sessions;

import com.company.UserType;
import com.company.users.User;

public class Session implements ISessionLogin, ISessionMenu {
    private User currrentUser;
    private boolean isSignup;
    private int menuSelection;

    public Session(User u) {
        currrentUser = u;
    }

    //ISessionLogin
    @Override
    public void setIsSignUp(boolean a) {isSignup = a;}

    @Override
    public void setUserId(int id) {
        currrentUser.setId(id);
    }

    @Override
    public void setUserType(UserType type) {
        currrentUser.setUserType(type);
    }

    @Override
    public boolean isSignup() {
        return isSignup;
    }

    @Override
    public void setMenuSelection(int s) {
        menuSelection = s;
    }

    public UserType getUserType() {
        return currrentUser.getUserType();
    }
    public int getMenuSelection() {return menuSelection;}
}
