package com.company;

public interface Observable {

    void addSubscriber(Observer observer);
    void removeSubscriber(Observer observer);
    void notifySubscribers(String tweet);
}
