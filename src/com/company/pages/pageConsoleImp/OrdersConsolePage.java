package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AOrdesPage;
import com.company.sessions.Session;

import java.util.Scanner;

public class OrdersConsolePage extends AOrdesPage {
    public OrdersConsolePage(Session session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);

        System.out.println("Showing user's Orders..");
        System.out.println("[9] Back to Main Menu");

        int selection = input.nextInt();
        session.setMenuSelection(selection);
        // something like - session.getUser().getOrders()
    }
}
