package com.company.pages.pageConsoleImp;
import com.company.pages.abstractPages.ASearchStorePage;
import com.company.sessions.ISession;
import java.util.Scanner;

public class SearchStoreConsolePage extends ASearchStorePage {
    public SearchStoreConsolePage(ISession session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                            Search Store by:
                            [0] Distance.
                            [1] Rating.
                            [4] Back.""");
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}
