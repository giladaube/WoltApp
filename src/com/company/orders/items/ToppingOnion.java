package com.company.orders.items;

class ToppingOnion extends ToppingsDecorator
{
    // Reference to decorated pizza
    Pizza pizza;

    public ToppingOnion(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() {
        return pizza.getItemDescription() + ", Onion ";
    }
    public double getPrice() { return 5 + pizza.getPrice(); }
}
