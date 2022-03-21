package com.company.pages.pageConsoleImp;
import com.company.users.IVirtualStore;
import com.company.pages.abstractPages.ASearchResultsPage;
import com.company.sessions.ISession;

import java.util.Scanner;

public class SearchResultsConsolePage extends ASearchResultsPage {
    public SearchResultsConsolePage(ISession session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        IVirtualStore a = session.getPickedStore();
        System.out.printf("""
                            Best Store for you --> %s,
                            [12] Show Store menu.
                            [4] Back to Main Menu.
                            [6] Change sort method.
                            """, a.getStoreName());
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}