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
        System.out.println("Hello");
        System.out.println("To Sign-in press 1, to Sign-up press 2");
        int userSelection = input.nextInt();
        // set which option do the user want to do: signIn or signUp
        session.setIsSignUp(userSelection == 2);
    }
}
