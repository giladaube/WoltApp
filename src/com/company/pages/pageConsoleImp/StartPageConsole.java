package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AStartPage;
import com.company.sessions.ISessionLogin;

import java.util.Scanner;

public class StartPageConsole extends AStartPage {
    public StartPageConsole(ISessionLogin s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                            Welcome!
                            Please choose an option:
                            [1] sign-in.
                            [2] sign-up.
                            [9] exit.
                            """);
        int userSelection = input.nextInt();
        // set which option do the user want to do: signIn or signUp
        session.setIsSignUp(userSelection == 2);
    }
}
