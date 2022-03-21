package com.company.orders.items;

class ToppingTomato extends ToppingsDecorator
{
    // Reference to decorated pizza
    Pizza pizza;

    public ToppingTomato(Pizza pizza) {
        this.pizza = pizza; }
    public String getDescription() {
        return pizza.getItemDescription() + ", Tomatoes ";
    }
    public double getPrice() { return 5 + pizza.getPrice(); }
}
