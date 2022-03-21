package com.company.orders.items;

public class ToppingOlives extends ToppingsDecorator
{
    // Reference to decorated pizza
    Pizza pizza;

    public ToppingOlives(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() {
        return pizza.getItemDescription() + ", Olives ";
    }
    public double getPrice() { return 5 + pizza.getPrice(); }
}

