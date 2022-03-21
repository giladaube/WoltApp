package com.company.Command;

import com.company.pages.GUI;
import com.company.db.IDatabase;
import com.company.users.Location;
import com.company.pages.Pages;
import com.company.pages.Search;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.ISession;
import com.company.users.RealStore;

import java.util.Map;

public class SearchStoreCommand implements ICommand {
    private GUI gui;
    private ISession session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    private IDatabase db;

    public SearchStoreCommand(GUI g, ISession s, AFactoryPage f, Map<Pages, ICommand> c, IDatabase d) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
        db = d;
    }
    @Override
    public void execute() {
        gui.setPage(factoryPage.getSearchStorePage());
        gui.show();
        try {
            session.setPermissions(this);
            if (Pages.values()[session.getMenuSelection()] == Pages.MAIN_MENU) {
                commands.get(Pages.MAIN_MENU).execute();
            }
            switch (Search.values()[session.getMenuSelection()]) {
                case DISTANCE -> {
                    //inject strategy sort by Distance
                    RealStore store = db.getBestStore((store1, store2) -> {
                        Location userLocation = session.getUser().getLocation();
                        //returns true if store1 is closer to user
                        return userLocation.distance(store1.getLocation()) <= userLocation.distance(store2.getLocation());
                    });
                    store.setVirtualStore(store);
                    session.setPickedStore(store.getVirtualStore());
                }
                case RATING -> {
                    //inject strategy sort by Rating
                    //returns true if rating of store1 is better than store2
                    RealStore store = db.getBestStore(
                            (store1, store2) -> store1.getRating() >= store2.getRating());
                    store.setVirtualStore(store);
                    session.setPickedStore(store.getVirtualStore());
                }
            }
            commands.get(Pages.SEARCH_RESULTS).execute();
        } catch (Exception e) {
            session.setErrorMessage(e.getMessage());
            commands.get(Pages.ERROR).execute();
            execute();
        }
    }
}