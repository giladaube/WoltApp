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
        int i = 0;
        System.out.printf("""
                            Welcome to %s
                            """, session.getPickedStore().getRealStore().getStoreName());
        System.out.println("You can chose as much items as you want, simply pick a number and hit Enter:");
        System.out.println("Here is our menu:");
        System.out.println("-----------------------------------");
        for(; i < items.size(); i++){
            IItem item = items.get(i);
            System.out.printf("""
                            Item number    [%d]
                            Name            %s
                            Description     %s
                            Price           %.2f
                            """, i, item.getItemName(),item.getItemDescription(), item.getPrice());
            System.out.println("-----------------------------------");
        }
        System.out.println("Please pick an item by it's number");
        System.out.println("Or chose another option:");
        System.out.printf("""
                            [%d] When you're DONE, we will send your order right away!
                            [%d] If you want to discard this order
                            """, i, i+1);
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}
