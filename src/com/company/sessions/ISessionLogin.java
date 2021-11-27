package com.company.sessions;

import com.company.UserType;

public interface ISessionLogin {
    public boolean isSignup();
    public void setIsSignUp(boolean a);
    public void setUserId(int id);
    public void setUserType(UserType type);

}
