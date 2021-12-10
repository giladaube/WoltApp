package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AMenuPage;
import com.company.sessions.ISessionMenu;
import com.company.sessions.Session;

import java.util.Scanner;

public class MenuPageCustomerConsole extends AMenuPage {
    public MenuPageCustomerConsole(Session s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                            Hello, there are several action you can do. Please enter a number based on your selection:
                            [1] Search store by..
                            [2] Show current orders.
                            [9] Logout.
                            """);

        int selection = input.nextInt();

        // set user selection
        session.setMenuSelection(selection);
    }
}
