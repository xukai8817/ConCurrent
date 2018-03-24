package com.edu.service.cache.impl;

import com.edu.service.cache.Computable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Future实现
 */
public class Memoizer3<A, V> implements Computable<A, V> {

    private Computable<A, V> c;

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> futureTask = new FutureTask<>(callable);
            future = futureTask;
            cache.put(arg, futureTask); // 此处可能重复提交
            futureTask.run();
        }
        try {
            return future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException("网络异常");
        }
    }
}
