package com.company.pages.pageConsoleImp;
import com.company.pages.abstractPages.ASignUpPage;
import com.company.sessions.ISession;

import java.util.Scanner;

public class SignUpPageConsole extends ASignUpPage {
    public SignUpPageConsole(ISession s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                Sign up:
                In order to Sign up, please provide the following information:
                """);

        System.out.println("Enter User name:");
        String name = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();

        session.setUserCredentials(name, password);
    }
}
