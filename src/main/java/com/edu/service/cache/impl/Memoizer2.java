package com.edu.service.cache.impl;

import com.edu.service.cache.Computable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用并发容器缓存数据<br>
 * 缺陷：<br>
 * 线程1、线程2计算相同数据<br>
 * 线程1访问缓存数据，未找到，执行计算<br>
 * 线程2访问缓存数据，未找到，线程1数据放入缓存，线程2执行计算<br>
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cacheMap = new ConcurrentHashMap<>();

    private Computable<A, V> c;

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cacheMap.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cacheMap.put(arg, result);
        }
        return result;
    }
}
