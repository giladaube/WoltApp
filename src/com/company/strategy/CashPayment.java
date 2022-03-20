package com.company.strategy;

public class CashPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.printf("paying with CASH - %.2f\n\n", amount);
    }

    @Override
    public boolean checkValidMethod() {
        // checking if card is legit...
        return true;
    }

}
