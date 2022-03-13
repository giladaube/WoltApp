package com.company.pages.pageConsoleImp;
import com.company.pages.abstractPages.ASignInPage;
import com.company.sessions.ISession;

import java.util.Scanner;

public class SignInPageConsole extends ASignInPage {
    public SignInPageConsole(ISession s) {
        super(s);
    }

    @Override
    public void showPage() {
        System.out.print("""
                Sign in:
                In order to Sign in, please provide the following information:
                """);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter User name:");
        String name = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();

        session.setUserCredentials(name, password);
    }
}
