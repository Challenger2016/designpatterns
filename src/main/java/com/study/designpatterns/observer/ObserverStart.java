package com.study.designpatterns.observer;

public class ObserverStart {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs1 = new ConcreteObserver1();
        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver(1);
        subject.add(obs1);
        subject.notifyObserver(1);
    }
}



