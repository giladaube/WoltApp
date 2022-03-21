package com.company.pages.pageConsoleImp;

import com.company.orders.IItem;
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

        int i = 0;
        System.out.printf("""
                            Welcome to %s
                            """, session.getPickedStore().getStoreName());

//        System.out.println("Would you like to see the full menu or make a custom order?");
//        System.out.printf("""
//                            [%d] Full Menu
//                            [%d] Custom Order
//                            """, i, i+1);
//
//        Scanner input = new Scanner(System.in);
//        int selection = input.nextInt();
//        if (selection == 1) {
//            System.out.println("Custom order chosen");
//        }
//        session.setMenuSelection(selection);

        List<IItem> items = session.getPickedStore().getItems();
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
        System.out.println("Or choose another option:");
        System.out.printf("""
                            [%d] When you're DONE, we will send your order right away!
                            [%d] If you want to discard this order
                            """, i, i+1);
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}
