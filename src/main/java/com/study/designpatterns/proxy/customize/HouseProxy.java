/**
 * @(#)HouseProxy.java
 *
 * @author Challenger
 * @version 1.0 2019年8月5日
 *
 * Copyright (C) 2000,2019 , TeamSun, Inc.
 */
package com.study.designpatterns.proxy.customize;


import com.study.designpatterns.proxy.House;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * Purpose:
 * 房屋代理
 * @author Challenger
 * @see	    
 * @since   6.1.0
 */
public class HouseProxy implements DInvocationHandler {

  private House house;
  
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {

    System.out.println("代理运行开始");
    Object invoke = null;
    try {
      invoke = method.invoke(house, args);
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("代理运行结束");
    return invoke;
  }
  
  public Object getInstance(House house) {
    this.house = house;
    Class<? extends House> class1 = house.getClass();
    try {
      return DProxy.getProxyInstance(new DClassLoader(), class1.getInterfaces(), this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
