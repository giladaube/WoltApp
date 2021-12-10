package com.company.sessions;

import com.company.UserType;
import com.company.users.User;

public class Session {
    private User currentUser;
    private String tempPassword="";
    private int menuSelection;

    public Session(User u) {
        currentUser = u;
    }

    public void setUserId(int id) {
        currentUser.setId(id);
    }

    public void setUserType(UserType type) {
        currentUser.setUserType(type);
    }

    public void setMenuSelection(int s) {
        menuSelection = s;
    }

    public UserType getUserType() {
        return currentUser.getUserType();
    }
    public int getMenuSelection() {return menuSelection;}

    public void setUserCredentials(String name, String password) {
        currentUser.setUserName(name);
        tempPassword = password;  // add pass in currentUser.setPass()
    }
    public String getTempPassword(){return tempPassword;}
    public String getUserName(){return currentUser.getUserName();}
}
