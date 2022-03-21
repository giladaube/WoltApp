package com.company.strategy;

public class PaymentStrategy {
    private PaymentMethod payment;

    public PaymentStrategy(PaymentMethod payment) {
        this.payment = payment;
    }

    public boolean makePayment(double amount) {
        if(payment.checkValidity()){
            payment.pay(amount);
            return true;
        }
        return false;
    }
}
