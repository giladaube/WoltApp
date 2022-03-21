package com.company.pages.pageConsoleImp;
import com.company.orders.IOrder;
import com.company.pages.abstractPages.AOrdesPage;
import com.company.sessions.ISession;
import java.util.Scanner;

public class OrdersConsolePage extends AOrdesPage {
    public OrdersConsolePage(ISession session) {
        super(session);
    }

    @Override
    public void showPage() {
        Scanner input = new Scanner(System.in);

        try {
            if (session.getOrders().size() == 0) {
                System.out.println("You have no orders. Go and order today!");
            } else {
                for (IOrder order : session.getOrders()) {
                    System.out.print(order.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("There is a problem, please try again later.");
        }

        System.out.println("[4] Back to Main Menu");

        int selection = input.nextInt();
        session.setMenuSelection(selection);
    }
}
