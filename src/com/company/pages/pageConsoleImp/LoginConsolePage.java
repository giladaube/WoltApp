package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.ALoginPage;
import com.company.sessions.Session;

import java.util.Scanner;

public class LoginConsolePage extends ALoginPage {
    public LoginConsolePage(Session session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.printf("""
                Welcome %s!
                [1] Sign-in.
                [2] Sign-up.
                [9] Back To Start.
                """, session.getUserType());
        int userSelection = input.nextInt();
        session.setMenuSelection(userSelection);
    }
}
