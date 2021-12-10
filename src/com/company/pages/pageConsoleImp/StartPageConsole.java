package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AStartPage;
import com.company.sessions.ISessionLogin;
import com.company.sessions.Session;

import java.util.Scanner;

public class StartPageConsole extends AStartPage {
    public StartPageConsole(Session s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                            Welcome!
                            Are you a Customer / Store:
                            [1] Customer.
                            [2] Store.
                            [9] Exit.""");
        int userSelection = input.nextInt();
        session.setMenuSelection(userSelection);

        // set which option do the user want to do: signIn or signUp
        // session.setIsSignUp(userSelection == 2);
    }
}
