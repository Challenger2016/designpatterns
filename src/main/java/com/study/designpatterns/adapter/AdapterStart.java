package com.study.designpatterns.adapter;

public class AdapterStart {

    public static void main(String[] args) {
        Target target = new Adapter();
        System.out.println(target.getPrice());
    }
}
