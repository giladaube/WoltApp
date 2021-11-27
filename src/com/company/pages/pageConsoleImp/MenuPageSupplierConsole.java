package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AMenuPage;
import com.company.sessions.ISessionMenu;

import java.util.Scanner;

public class MenuPageSupplierConsole extends AMenuPage {
    public MenuPageSupplierConsole(ISessionMenu s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, there are several action you can do. Please enter a number based on your selection");
        System.out.println("** Search an item, please press 1");
        System.out.println("** See your on-going orders, please press 2");
        System.out.println("** Log out, please press 3");

        int selection = input.nextInt();

        // set user selection
        session.setMenuSelection(selection);
    }
}
