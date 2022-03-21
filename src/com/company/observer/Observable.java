package com.company.observer;

public interface Observable {

    void setSubscriber(Observer observer);
//    void removeSubscriber(Observer observer);
    void notifySubscribers(int info);
}
