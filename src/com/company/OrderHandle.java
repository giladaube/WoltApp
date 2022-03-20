package com.company;

import com.company.strategy.PaymentStrategy;
import com.company.users.Customer;

import java.util.ArrayList;
import java.util.List;

// NEED TO ADD Observable
public class OrderHandle implements Observable, Observer {
    private List<IOrder> orders = new ArrayList<>();
    private PaymentStrategy paymentHandler;
    private Observer customer;
    public OrderHandle(){
//        customer = c;
//        paymentHandler = new PaymentStrategy(customer.getPaymentMethod());
    }

    public void addOrder(IOrder order) throws InterruptedException {
//        if(paymentHandler.payAmount(order.getPrice())){
            // send the order here - after payAmount is done
            orders.add(order);
            order.getStore().addOrder(order);
//        }
        // order.setOrderNumber(db.addOrder(order));
//        boolean confirmation = order.getStore().addOrder(order);
        // NEED TO NOTIFY CUSTOMER ABOUT CONFIRMATION
    }

    public List<IOrder> getOrders(){return orders;}

    @Override
    public void addSubscriber(Observer observer) {
        this.customer = observer;
    }

    @Override
    public void removeSubscriber(Observer observer) {

    }

    @Override
    public void notifySubscribers(String tweet) {

    }

    @Override
    public void update(int OrderID) {
        this.customer.update(OrderID);
    }
}
