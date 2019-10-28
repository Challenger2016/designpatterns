package com.study.designpatterns.adapter;

public class Adapter extends Adaptee implements Target {

    @Override
    public Double getPrice() {
        return Double.parseDouble(super.price());
    }
}
