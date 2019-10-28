/**
 * @(#)BieShu.java
 *
 * @author Challenger
 * @version 1.0 2019年8月5日
 *
 * Copyright (C) 2000,2019 , TeamSun, Inc.
 */
package com.study.designpatterns.proxy;

/**
 * 某座别墅
 * @author Challenger
 */
public class BieShu implements House {

  private String address = "西藏南路255号500室";
  
  private String phone = "13888888888";
  
  @Override
  public String getAddress() {

    System.out.println("地址：西藏南路255号500室");
    return address;
  }

  @Override
  public String getPhone() {

    System.out.println("手机号：13888888888");
    return phone;
  }

}