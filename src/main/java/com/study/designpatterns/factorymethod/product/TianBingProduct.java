package com.study.designpatterns.factorymethod.product;


public class TianBingProduct implements Product {

    private String name;

    public TianBingProduct(String name) {
        this.name = name;
    }

    @Override
    public String getName() {

       return name;
    }
}
