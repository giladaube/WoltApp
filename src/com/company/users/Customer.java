package com.company.users;

import com.company.observer.Observer;
import com.company.orders.IItem;
import com.company.orders.IOrder;
import com.company.orders.Order;
import com.company.orders.OrderHandler;
import com.company.strategy.CreditCardPayment;
import com.company.strategy.PaymentMethod;
import com.company.strategy.PaymentStrategy;

import java.util.List;

public class Customer extends User implements Observer {
    private OrderHandler orderHandler;
    private PaymentMethod paymentMethod;
    public Customer(String name, String pass, Location loc){
        super(name, pass, UserType.CUSTOMER, loc);
    }
    public Customer(String name, String pass){
        super(name, pass, UserType.CUSTOMER, Location.generateRandomLocation());
        // everyone pays with card. can get card info when sign-up
        paymentMethod = new CreditCardPayment();
        this.orderHandler = new OrderHandler();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        orderHandler.setPaymentHandler(new PaymentStrategy(paymentMethod));
    }

    public void addOrder(List<IItem> items, IVirtualStore store) throws InterruptedException {
        orderHandler.setSubscriber(this); //GSON can't handle circular dependency, we add "this" here
        orderHandler.setPaymentHandler(new PaymentStrategy(this.paymentMethod));
        orderHandler.addOrder(new Order(items, store, orderHandler));
    }
    public List<IOrder> getOrders(){return orderHandler.getOrders();}

    @Override
    public void update(int info) {
        switch (info) {
            case 1:
                System.out.println("Order Status Changed: Cooking...");
                break;
            case 2:
                System.out.println("Order Status Changed: Done! In Delivery...");
                break;
            case 3:
                System.out.println("Order Status Changed: Order has arrived!");
                break;
        }
    }
}
