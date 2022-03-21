package com.company.orders;

import com.company.observer.Observable;
import com.company.observer.Observer;
import com.company.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderHandler implements Observable, Observer {
    private List<IOrder> orders = new ArrayList<>();
    private PaymentStrategy paymentHandler;
    private Observer customer;

    public void addOrder(IOrder order) throws InterruptedException {
        // send the order if payment was successful
        if(paymentHandler.makePayment(order.getPrice())){
            orders.add(order);
            order.getStore().addOrder(order);
        }
    }

    public void setPaymentHandler(PaymentStrategy paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    public List<IOrder> getOrders(){return orders;}

    @Override
    public void setSubscriber(Observer customer) {
        this.customer = customer;
    }

    @Override
    public void update(int info) {
        notifySubscribers(info);
    }

    @Override
    public void notifySubscribers(int info) {
        this.customer.update(info);
    }
}
