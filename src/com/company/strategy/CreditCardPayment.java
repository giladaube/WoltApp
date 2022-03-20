package com.company.strategy;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("paying with Credit Card - %.2f\n\n", amount);
    }
    @Override
    public boolean checkValidity() {
        // checking if card is legit...
        return true;
    }
}
