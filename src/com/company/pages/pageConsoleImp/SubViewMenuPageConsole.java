package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AMenuViewPage;
import com.company.sessions.ISession;

import java.util.Scanner;

public class SubViewMenuPageConsole extends AMenuViewPage {
    //util class to get more than one menu item selection
    public SubViewMenuPageConsole(ISession session) {
        super(session);
    }
    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}
