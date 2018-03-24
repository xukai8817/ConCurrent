package com.edu.service.cache.impl;

import com.edu.service.cache.Computable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xukai 每次只有一个线程可以访问，效率低下
 */
public class Memoizer1<A, V> implements Computable<A, V> {

  private final Map<A, V> cache = new HashMap<>();
  private final Computable<A, V> c;

  public Memoizer1(Computable<A, V> c) {
    this.c = c;
  }

  /**
   * 单线程访问
   * @param arg
   * @return
   * @throws InterruptedException
   */
  @Override
  public synchronized V compute(A arg) throws InterruptedException {
    V result = cache.get(arg);
    if (result == null) {
      result = c.compute(arg);
      cache.put(arg, result);
    }
    return result;
  }

}
