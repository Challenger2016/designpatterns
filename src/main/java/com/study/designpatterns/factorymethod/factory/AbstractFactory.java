package com.study.designpatterns.factorymethod.factory;


import com.study.designpatterns.factorymethod.product.Product;

public interface AbstractFactory {

    Product newProduct();
}
