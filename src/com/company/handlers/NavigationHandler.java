package com.company.handlers;

import com.company.FileDB;
import com.company.GUI;
import com.company.IDatabase;
import com.company.UserType;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;
import com.company.users.User;

public class NavigationHandler {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Pages curPage;
    private boolean run;
    private IDatabase db;
    public NavigationHandler(GUI g, Session s, AFactoryPage f) {
        gui = g;
        session = s;
        factoryPage = f;
        curPage = Pages.START;
        run = true;
        db = FileDB.getDatabase();
    }

//    private void login() {
//        LoginHandler loginHandler = new LoginHandler(factoryPage, gui, session);
//        loginHandler.start();
//    }

//    private int menu() {
//        gui.setPage(factoryPage.getMenuPage());
//        gui.show();
//        return session.getMenuSelection();
//    }
    public void start() {
        while(run){
            switch (curPage){
                case START -> startHandler();
                case LOGIN -> loginHandler();
                case SIGN_IN -> signInHandler();
                case SIGN_UP -> signUpHandler();
                case REDIRECT -> redirectHandler();
                case MAIN_MENU -> mainMenuHandler();
                case EXIT -> run=false;
            }
        }
    }

    private void mainMenuHandler() {
        if(session.getUserType()==UserType.CUSTOMER)
            (new CustomerNavigationHandler(gui, session, factoryPage, db)).start();
        else
            (new StoreNavigationHandler(gui, session, factoryPage, db)).start();
    }

    private void loginHandler() {
        gui.setPage(factoryPage.getLoginPage());
        gui.show();
        switch (session.getMenuSelection()){
            case 1 -> curPage = Pages.SIGN_IN;
            case 2 -> curPage = Pages.SIGN_UP;
            case 9 -> curPage = Pages.START;
        }
    }

    private void startHandler(){
        gui.setPage(factoryPage.getStartPage());
        gui.show();
        switch (session.getMenuSelection()){
            case 1 -> {
                session.setUserType(UserType.CUSTOMER);
                curPage = Pages.LOGIN;
            }
            case 2 -> {
                session.setUserType(UserType.STORE);
                curPage = Pages.LOGIN;
            }
            case 9 -> curPage = Pages.EXIT;
        }
    }

    private void redirectHandler(){ // for now - redirect back to start
        gui.setPage(factoryPage.getRedirectionPage());
        gui.show();
        curPage = Pages.START;
    }
    private void signInHandler() {
        gui.setPage(factoryPage.getSignInPage());
        gui.show();
        User user = db.checkUserExists(session.getUserName(), session.getTempPassword());
        if(user != null){
            // session.setUser();
            curPage = Pages.MAIN_MENU;
        }
        else
            curPage = Pages.REDIRECT;
    }

    private void signUpHandler() {
        gui.setPage(factoryPage.getSignUpPage());
        gui.show();
    }

}
