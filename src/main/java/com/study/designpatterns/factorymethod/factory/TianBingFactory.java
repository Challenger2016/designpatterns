package com.study.designpatterns.factorymethod.factory;


import com.study.designpatterns.factorymethod.product.Product;
import com.study.designpatterns.factorymethod.product.TianBingProduct;

public class TianBingFactory implements AbstractFactory {
    @Override
    public Product newProduct() {
        return new TianBingProduct("甜饼");
    }
}
