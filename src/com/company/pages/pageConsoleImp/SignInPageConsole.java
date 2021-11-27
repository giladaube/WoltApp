package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.ASignInPage;
import com.company.sessions.ISessionLogin;
import com.company.UserType;

import java.util.Scanner;

public class SignInPageConsole extends ASignInPage {
    public SignInPageConsole(ISessionLogin s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter User name:");
        String name = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();

        // verify given input with DB, and get userId and type
        session.setUserId(1234);
        session.setUserType(UserType.CUSTOMER);
    }
}
