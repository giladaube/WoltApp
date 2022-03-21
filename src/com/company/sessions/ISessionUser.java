package com.company.sessions;

import com.company.users.UserType;
import com.company.users.User;

public interface ISessionUser {
    void setUser(User u);
    User getUser();
    void setUserType(UserType type);
    UserType getUserType();
    void setUserCredentials(String name, String password);
    void setUserId(int id);
    String getTempPassword();
    String getUserName();
}
