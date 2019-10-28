package com.study.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observers = new ArrayList<Observer>();

    //增加观察者方法
    void add(Observer observer) {
        observers.add(observer);
    }

    //删除观察者方法
    void remove(Observer observer) {
        observers.remove(observer);
    }

    abstract void notifyObserver(double price); //通知观察者方法
}