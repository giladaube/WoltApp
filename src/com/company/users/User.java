package com.company.users;

import java.util.UUID;

public class User {
    private int id;
    private UserType userType;
    private String name;
    private Location location;
    private String password;

    public User(){}  // default CTOR

    public User(String name, String pass, UserType type, Location loc){  // CTOR for creation
        this.name = name;
        this.userType = type;
        this.location = loc;
        this.password = pass;
        this.id = UUID.randomUUID().hashCode();
    }
    public void setUserName(String name){ this.name = name;}
    public String getUserName(){return name;}

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword(){return password;}

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

    public Location getLocation(){ return location; }
}
