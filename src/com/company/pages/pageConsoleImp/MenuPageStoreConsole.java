package com.company.pages.pageConsoleImp;
import com.company.pages.abstractPages.AMenuPage;
import com.company.sessions.ISession;

import java.util.Scanner;

public class MenuPageStoreConsole extends AMenuPage {
    public MenuPageStoreConsole(ISession s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.printf("""
                            Hello %s,
                            There are several action you can do. Please enter a number based on your selection:
                            [1] Search an item.
                            [2] See your on-going orders.
                            [10] Logout.
                            """, session.getUserName());
        int selection = input.nextInt();

        // set user selection
        session.setMenuSelection(selection);
    }
}
