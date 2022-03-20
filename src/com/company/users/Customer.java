package com.company.users;

import com.company.*;
import com.company.strategy.CreditCardPayment;
import com.company.strategy.PaymentMethod;

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
        this.orderHandle = new OrderHandle();

        // everyone pays with card. can get card info when sign-up...
//        paymentMethod = new CreditCardPayment();
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void addOrder(List<IItem> items, IVirtualStore store) throws InterruptedException {
        System.out.println("Got to addOrder in Customer");
        orderHandle.addSubscriber(this);
        orderHandle.addOrder(new Order(items, store, orderHandle));
    }
    public List<IOrder> getOrders(){return orderHandle.getOrders();}

    @Override
    public void update(int OrderID) {
        System.out.printf("Order Status Changed for Order %d\n", OrderID);
    }
}
