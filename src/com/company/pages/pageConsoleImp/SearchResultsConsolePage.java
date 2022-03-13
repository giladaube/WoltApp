package com.company.pages.pageConsoleImp;
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
        System.out.println("""
                            Search Results
                            [4] Back to Main Menu.
                            [6] Change sort method.
                            """);
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}