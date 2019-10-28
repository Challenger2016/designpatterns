package com.study.designpatterns.observer;

public class ConcreteSubject extends Subject {
    public void notifyObserver(double price) {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for (Object obs : observers) {
            ((Observer) obs).response(1);
        }

    }
}