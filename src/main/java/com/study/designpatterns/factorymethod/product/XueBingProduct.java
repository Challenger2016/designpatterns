package com.study.designpatterns.factorymethod.product;

public class XueBingProduct implements Product {

    private String name;

    public XueBingProduct(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
