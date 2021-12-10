package com.company.handlers;

import com.company.GUI;
import com.company.IDatabase;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

public class CustomerNavigationHandler {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Pages curPage;
    private boolean run;
    private IDatabase db;
    public CustomerNavigationHandler(GUI gui, Session session, AFactoryPage factoryPage, IDatabase db) {
        this.gui = gui;
        this.session = session;
        this.factoryPage = factoryPage;
        this.curPage = Pages.MAIN_MENU;
        this.run = true;
        this.db = db;
    }

    public void start() {
        while(run){
            switch (curPage){
                case MAIN_MENU -> mainMenuHandler();
                case SEARCH_STORES_BY -> storeSearchHandler();
                case SEARCH_RESULTS -> searchResultsHandler();
                case ORDERS -> ordersHandler();
                case EXIT -> run = false;
            }
        }
    }

    private void searchResultsHandler() {
    }

    private void ordersHandler() {
        gui.setPage(factoryPage.getOrdersPage());
        gui.show();
        switch (session.getMenuSelection()){
            case 9 -> curPage = Pages.MAIN_MENU;
        }
    }

    private void storeSearchHandler() {
        gui.setPage(factoryPage.getSearchStorePage());
        gui.show();
        switch (session.getMenuSelection()){
            case 1 -> {
                //inject strategy sort by Distance
                curPage = Pages.SEARCH_RESULTS;
            }
            case 2 -> {
                //inject strategy sort by Rating
                curPage = Pages.SEARCH_RESULTS;
            }
            case 9 -> curPage = Pages.MAIN_MENU;
        }
    }

    private void mainMenuHandler() {
        gui.setPage(factoryPage.getMenuPage());
        gui.show();
        switch (session.getMenuSelection()){
            case 1 -> curPage = Pages.SEARCH_STORES_BY;
            case 2 -> curPage = Pages.ORDERS;
            case 9 -> curPage = Pages.EXIT;
        }
    }
}
