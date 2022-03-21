package com.company.sessions;

import com.company.Command.ICommand;
import com.company.Command.SignInCommand;
import com.company.Command.SignUpCommand;
import com.company.Command.StartCommand;
import com.company.orders.IItem;
import com.company.orders.IOrder;
import com.company.users.IVirtualStore;
import com.company.users.UserType;
import com.company.pages.IPage;
import com.company.pages.abstractPages.ASignInPage;
import com.company.pages.abstractPages.ASignUpPage;
import com.company.users.User;

import java.util.List;

public class SessionProxy implements ISession{
    private ISession session;
    private Object object;

    public SessionProxy() {session = new Session();}

    // anyone should have access
    public void setPermissions(Object o) {
        object = o;
    }

    // only a customer should have access to this method
    @Override
    public List<IOrder> getOrders() {
        if (session.getUser().getUserType() == UserType.CUSTOMER)
            return session.getOrders();
        return null;
    }

    // only a customer should have access to this method
    @Override
    public IVirtualStore getPickedStore() {
        return session.getPickedStore();
    }

    @Override
    public void setPickedStore(IVirtualStore store) {
        session.setPickedStore(store);
    }

    // anyone should have access to Errors
    @Override
    public void setErrorMessage(String msg) {
        session.setErrorMessage(msg);
    }

    @Override
    public String getErrorMessage() {
        return session.getErrorMessage();
    }

    @Override
    public void setMenuSelection(int s) {
        // let only user input set menu selection, which is used only on IPages
        if (object instanceof IPage) {
            session.setMenuSelection(s);
        }
    }

    @Override
    public int getMenuSelection() {
        // access to user selection should be able only from ICommand
        if (object instanceof ICommand) {
            return session.getMenuSelection();
        }
        return 0;
    }

    // only a store should have access to this method
    @Override
    public List<IItem> getItems() {
        if (session.getUser().getUserType() == UserType.STORE)
            return session.getItems();
        return null;
    }

    @Override
    public void setUser(User u) {
        session.setUser(u);
    }

    @Override
    public User getUser() {
        return session.getUser();
    }

    // usertype should be set only once on setup
    @Override
    public void setUserType(UserType type) {
        if (object instanceof StartCommand) {
            session.setUserType(type);
        }
    }

    @Override
    public UserType getUserType() {
        return session.getUserType();
    }

    // should only set credentials on log-in or sign-up
    @Override
    public void setUserCredentials(String name, String password) {
        if (object instanceof ASignInPage || object instanceof ASignUpPage) {
            session.setUserCredentials(name, password);
        }
    }

    // should only set user id on log-in or sign-up
    @Override
    public void setUserId(int id) {
        if (object instanceof SignInCommand || object instanceof SignUpCommand) {
            session.setUserId(id);
        }
    }

    // should only be access during log-in or sign-up
    @Override
    public String getTempPassword() {
        if (object instanceof SignInCommand || object instanceof SignUpCommand) {
            return session.getTempPassword();
        }
        return null;
    }

    @Override
    public String getUserName() {
        return session.getUserName();
    }
}
