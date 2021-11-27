package com.company.users;

import com.company.UserType;

public class User {
    private int id;
    private UserType userType;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }
}
