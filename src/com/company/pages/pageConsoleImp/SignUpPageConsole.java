package com.company.pages.pageConsoleImp;

import com.company.sessions.ISessionLogin;
import com.company.pages.abstractPages.ASignUpPage;
import com.company.UserType;

import java.util.Scanner;

public class SignUpPageConsole extends ASignUpPage {
    public SignUpPageConsole(ISessionLogin s) {
        super(s);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("If you are a Customer please press 1, if you are a Supplier please press 2");
        String type = input.nextLine();

        // set user type (customer or supplier)
        if (type.equals("1"))
            session.setUserType(UserType.CUSTOMER);
        else
            session.setUserType(UserType.SUPPLIER);

        System.out.println("Enter User name:");
        String name = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();

        // add given input to DB, get in return userId.
        session.setUserId(1234);
    }
}
