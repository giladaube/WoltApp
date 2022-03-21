package com.company.sessions;

import com.company.users.UserType;
import com.company.users.User;

public class SessionUser implements ISessionUser{
    private User currentUser = new User();

    @Override
    public User getUser() {
        return currentUser;
    }
    @Override
    public void setUser(User u){
        currentUser = u;
    }
    @Override
    public void setUserType(UserType type) {
        currentUser.setUserType(type);
    }

    @Override
    public UserType getUserType() {
        try {
            return currentUser.getUserType();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public void setUserCredentials(String name, String password) {
        currentUser.setUserName(name);
        currentUser.setPassword(password);
    }

    @Override
    public void setUserId(int id) {
        currentUser.setId(id);
    }

    @Override
    public String getTempPassword() {
        try {
            return currentUser.getPassword();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public String getUserName() {
        try {
            return currentUser.getUserName();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }
}
