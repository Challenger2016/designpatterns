package com.study.designpatterns.proxy.cglib;


import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        // 创建代理对象
        HelloService proxy= (HelloService)new MyMethodInterceptor().getProxy(HelloService.class);
        // 通过代理对象调用目标方法
        proxy.sayHello();
    }
}
