package com.company.strategy;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("paying with credit card - %.2f", amount);
    }

    @Override
    public boolean checkValidMethod() {
        // checking if card is legit...
        return true;
    }
}
