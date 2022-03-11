package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.ASearchResultsPage;
import com.company.sessions.Session;
import java.util.Scanner;

public class SearchResultsConsolePage extends ASearchResultsPage {
    public SearchResultsConsolePage(Session session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                            Search Results
                            [9] Back.
                            """);
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}