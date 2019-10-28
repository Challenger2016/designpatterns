/*
 * Copyright (c) 1999, 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.study.designpatterns.proxy.customize;

import java.lang.reflect.Method;

public interface DInvocationHandler {

  /**
   * 代理
   * @param proxy
   * @param method
   * @param args
   * @return
   */
  Object invoke(Object proxy, Method method, Object... args);
}
