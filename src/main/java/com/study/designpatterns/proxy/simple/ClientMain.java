/**
 * @(#)Client.java
 *
 * @author Challenger
 * @version 1.0 2019年8月5日
 *
 * Copyright (C) 2000,2019 , TeamSun, Inc.
 */
package com.study.designpatterns.proxy.simple;

import com.study.designpatterns.proxy.BieShu;
import com.study.designpatterns.proxy.House;

/**
 * 
 * Purpose:
 * 客户
 * @author Challenger
 * @see	    
 * @since   6.1.0
 */
public class ClientMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub  
    House instance = (House) new HouseProxy().getInstance(new BieShu());
    String address = instance.getAddress();
    System.out.println("获取到房子地址：" + address);
    String phone = instance.getPhone();
    System.out.println("获取到房主手机号：" + phone);
  }

}