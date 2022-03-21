package com.company.strategy;

public interface PaymentMethod {
    void pay(double amount);
    boolean checkValidity();
}
