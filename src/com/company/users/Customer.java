package com.company.users;

import com.company.*;
import com.company.strategy.CreditCardPayment;
import com.company.strategy.PaymentMethod;

import java.util.List;

// NEED TO ADD Observer
public class Customer extends User {
    private OrderHandle orderHandle;
    private PaymentMethod paymentMethod;
    public Customer(String name, String pass, Location loc){
        super(name, pass, UserType.CUSTOMER, loc);
    }
    public Customer(String name, String pass){
        super(name, pass, UserType.CUSTOMER, Location.generateRandomLocation());
        orderHandle = new OrderHandle(this);
        // everyone pays with card. can get card info when sign-up...
        paymentMethod = new CreditCardPayment();
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void addOrder(List<IItem> items, IVirtualStore store) {

        orderHandle.addOrder(store.newOrder(items));
    }
    public List<IOrder> getOrders(){return orderHandle.getOrders();}
}
