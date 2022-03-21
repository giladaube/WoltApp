package com.company.pages.pageConsoleImp;
import com.company.pages.abstractPages.AErrorPage;
import com.company.sessions.ISession;
import java.util.Scanner;

public class ErrorPageConsole extends AErrorPage {
    public ErrorPageConsole(ISession session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s.
                [0] Back To Start.
                [1] Try again.
                [4] Back To Menu.
                [10] Exit.
                """, session.getErrorMessage());

        int userSelection = input.nextInt();
        session.setMenuSelection(userSelection);
    }
}