package com.study.designpatterns.factorymethod.factory;

import com.study.designpatterns.factorymethod.product.Product;
import com.study.designpatterns.factorymethod.product.XueBingProduct;

public class XueBingFactory implements AbstractFactory {
    @Override
    public Product newProduct() {
        return new XueBingProduct("雪饼");
    }
}
