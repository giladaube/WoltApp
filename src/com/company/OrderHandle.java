package com.company;

import com.company.strategy.PaymentStrategy;
import com.company.users.Customer;

import java.util.List;

// NEED TO ADD Observable
public class OrderHandle {
    private List<IOrder> orders;
    private PaymentStrategy paymentHandler;
    private Customer customer;
    public OrderHandle(Customer c){
        customer = c;
        paymentHandler = new PaymentStrategy(customer.getPaymentMethod());
    }

    public void addOrder(IOrder order) {
        if(paymentHandler.payAmount(order.getPrice())){
            // send the order here - after payAmount is done
            orders.add(order);
        }
        // order.setOrderNumber(db.addOrder(order));
        boolean confirmation = order.getStore().addOrder(order);
        // NEED TO NOTIFY CUSTOMER ABOUT CONFIRMATION
    }

    public List<IOrder> getOrders(){return orders;}
}
