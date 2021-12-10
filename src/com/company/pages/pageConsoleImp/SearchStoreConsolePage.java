package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.ASearchStore;
import com.company.sessions.Session;

import java.util.Scanner;

public class SearchStoreConsolePage extends ASearchStore {
    public SearchStoreConsolePage(Session session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                            Search Store by:
                            [1] Distance.
                            [2] Rating.
                            [9] Back.
                            """);
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}
