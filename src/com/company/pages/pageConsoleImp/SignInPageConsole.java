package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.ASignInPage;
import com.company.sessions.ISessionLogin;
import com.company.UserType;
import com.company.sessions.Session;

import java.util.Scanner;

public class SignInPageConsole extends ASignInPage {
    public SignInPageConsole(Session s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter User name:");
        String name = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();
        session.setUserCredentials(name, password);
    }
}
