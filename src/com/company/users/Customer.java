package com.company.users;

import com.company.*;
import com.company.strategy.CreditCardPayment;
import com.company.strategy.PaymentMethod;
import com.company.strategy.PaymentStrategy;

import java.util.List;

// NEED TO ADD Observer
public class Customer extends User implements Observer {
    private OrderHandle orderHandle;
    private PaymentMethod paymentMethod;
    public Customer(String name, String pass, Location loc){
        super(name, pass, UserType.CUSTOMER, loc);
    }
    public Customer(String name, String pass){
        super(name, pass, UserType.CUSTOMER, Location.generateRandomLocation());
        // everyone pays with card. can get card info when sign-up...
        paymentMethod = new CreditCardPayment();
        this.orderHandle = new OrderHandle();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        orderHandle.setPaymentHandler(new PaymentStrategy(paymentMethod));
    }

    public void addOrder(List<IItem> items, IVirtualStore store) throws InterruptedException {
        System.out.println("Got to addOrder in Customer");
        orderHandle.addSubscriber(this); //GSON can't handle circular dependency, we add "this" here
        orderHandle.setPaymentHandler(new PaymentStrategy(this.paymentMethod));
        orderHandle.addOrder(new Order(items, store, orderHandle));
    }
    public List<IOrder> getOrders(){return orderHandle.getOrders();}

    @Override
    public void update(int OrderID) {
        System.out.printf("Order Status Changed for Order %d\n", OrderID);
    }
}
