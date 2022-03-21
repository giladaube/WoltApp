package com.company.pages.pageConsoleImp;

import com.company.pages.IPage;
import com.company.pages.abstractPages.ALoginPage;
import com.company.sessions.ISession;

import java.util.Scanner;

public class LoginConsolePage extends ALoginPage {
    public LoginConsolePage(ISession session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                Welcome %s!
                [2] Sign-in.
                [3] Sign-up.
                [0] Back To Start.
                """, session.getUserType());
        int userSelection = input.nextInt();
        session.setMenuSelection(userSelection);
    }
}
