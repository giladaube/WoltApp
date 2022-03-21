package com.company.sessions;

public interface ISession extends ISessionCustomer, ISessionError, ISessionMenu, ISessionStore, ISessionUser  {
    void setPermissions(Object o);
}
