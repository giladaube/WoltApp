package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AStartPage;
import com.company.sessions.ISession;

import java.util.Scanner;

public class StartPageConsole extends AStartPage {
    public StartPageConsole(ISession s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                            Welcome!
                            Are you a Customer / Store:
                            [0] Customer.
                            [1] Store.
                            [10] Exit.""");
        int userSelection = input.nextInt();
        session.setMenuSelection(userSelection);
    }
}
