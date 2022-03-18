package com.company.pages.pageConsoleImp;

import com.company.IItem;
import com.company.pages.abstractPages.AMenuViewPage;
import com.company.sessions.ISession;

import java.util.List;
import java.util.Scanner;

public class ViewMenuPageConsole extends AMenuViewPage {

    public ViewMenuPageConsole(ISession session) {
        super(session);
    }
    @Override
    public void showPage() {
        List<IItem> items = session.getPickedStore().getItems();
        for(int i=0; i < items.size(); i++){
            System.out.printf("item number %d", i);
            IItem item = items.get(i);
            System.out.println(item.getItemName());
            System.out.println(item.getItemDescription());
            System.out.println(item.getPrice());
        }
        System.out.println("Please pick an item");
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}
