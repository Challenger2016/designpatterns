package com.study.designpatterns.observer;

//具体观察者1
public class ConcreteObserver2 implements Observer {
    @Override
    public void response(double price) {
        System.out.println("农民2收到猪肉价格变动的消息");
    }
}