package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.AErrorPage;
import com.company.sessions.Session;

public class ErrorPageConsole extends AErrorPage {
    public ErrorPageConsole(Session session) {
        super(session);
    }

    @Override
    public void showPage() {
        System.out.print("""
                Please try again
                """);
    }
}