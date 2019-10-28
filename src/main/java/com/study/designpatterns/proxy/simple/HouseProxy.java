/**
 * @(#)HouseProxy.java
 *
 * @author Challenger
 * @version 1.0 2019年8月5日
 *
 * Copyright (C) 2000,2019 , TeamSun, Inc.
 */
package com.study.designpatterns.proxy.simple;

import com.study.designpatterns.proxy.House;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 房屋代理
 * @author Challenger
 */
public class HouseProxy implements InvocationHandler {

  private House house;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    System.out.println("代理运行开始");
    Object invoke = method.invoke(house, args);
    System.out.println("代理运行结束");
    return invoke;
  }

  public Object getInstance(House house) {
    this.house = house;
    Class<? extends House> class1 = house.getClass();
    return Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), this);
  }

}

