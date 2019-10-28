package com.study.designpatterns.factorymethod;

import com.study.designpatterns.factorymethod.factory.AbstractFactory;
import com.study.designpatterns.factorymethod.factory.TianBingFactory;
import com.study.designpatterns.factorymethod.factory.XueBingFactory;
import com.study.designpatterns.factorymethod.product.Product;

public class Start {
    public static void main(String[] args) {
        AbstractFactory xueBingFactory = new XueBingFactory();
        Product xueBingProduct = xueBingFactory.newProduct();
        System.out.println(xueBingProduct.getName());

        AbstractFactory tianBingFactory = new TianBingFactory();
        Product tianBingProduct = tianBingFactory.newProduct();
        System.out.println(tianBingProduct.getName());
    }
}
