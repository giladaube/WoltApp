package com.company.pages.pageConsoleImp;

import com.company.pages.abstractPages.ARedirectionPage;

public class RedirectionConsolePage extends ARedirectionPage {
    @Override
    public void showPage() {
        System.out.println("""
                            Oh No! An Error accrued!
                            Redirecting you back to Start Page""");
    }
}
