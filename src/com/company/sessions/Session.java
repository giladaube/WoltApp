package com.company.sessions;
import com.company.IItem;
import com.company.IOrder;
import com.company.IVirtualStore;
import com.company.UserType;
import com.company.users.ARealStore;
import com.company.users.Customer;
import com.company.users.IRealStore;
import com.company.users.User;
import java.util.List;

public class Session implements ISession {
    private ISessionCustomer sessionCustomer;
    private ISessionError sessionError;
    private ISessionMenu sessionMenu;
    private ISessionStore sessionStore;
    private ISessionUser sessionUser;

    public Session() {
        sessionUser = new SessionUser();
        sessionMenu = new SessionMenu();
        sessionError = new SessionError();
    }

    @Override
    public void setErrorMessage(String msg) {
        sessionError.setErrorMessage(msg);
    }

    @Override
    public String getErrorMessage() {
        return sessionError.getErrorMessage();
    }

    @Override
    public void setMenuSelection(int s) {
        sessionMenu.setMenuSelection(s);
    }

    @Override
    public int getMenuSelection() {
        return sessionMenu.getMenuSelection();
    }

    @Override
    public void setUser(User u) {
        sessionUser.setUser(u);
    }

    @Override
    public User getUser() {
        return sessionUser.getUser();
    }

    @Override
    public void setUserType(UserType type) {
        sessionUser.setUserType(type);
        if (type == UserType.CUSTOMER) {
            sessionCustomer = new SessionCustomer(new Customer(sessionUser.getUserName(), sessionUser.getTempPassword()));
        }
//        else {
//            sessionStore = new SessionStore(new ARealStore(sessionUser.getUserName(), sessionUser.getTempPassword()));
//        }
    }

    @Override
    public UserType getUserType() {
        return sessionUser.getUserType();
    }

    @Override
    public void setUserCredentials(String name, String password) {
        sessionUser.setUserCredentials(name, password);
    }

    @Override
    public void setUserId(int id) {
        sessionUser.setUserId(id);
    }

    @Override
    public String getTempPassword() {
        return sessionUser.getTempPassword();
    }

    @Override
    public String getUserName() {
        return sessionUser.getUserName();
    }

    @Override
    public List<IOrder> getOrders() {
        try {
            return sessionCustomer.getOrders();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public IVirtualStore getPickedStore() {
        return sessionCustomer.getPickedStore();
    }

    @Override
    public void setPickedStore(IVirtualStore store) {
        sessionCustomer.setPickedStore(store);
    }

    @Override
    public List<IItem> getItems() {
        try {
            return sessionStore.getItems();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void setPermissions(Object o) {
        // don't do anything
    }
}
