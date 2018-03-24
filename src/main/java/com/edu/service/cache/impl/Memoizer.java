package com.edu.service.cache.impl;

import com.edu.service.cache.Computable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 最终版
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private Computable<A, V> c;

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            System.out.println("缓存中未查找到");
            FutureTask<V> futureTask = new FutureTask<>(new MyCallable<A, V>(c, arg));
            future = cache.putIfAbsent(arg, futureTask);
            if (future == null) {
                System.out.println("添加FutrueTask");
                future = futureTask;
                futureTask.run();
            }
        }
        try {
            return future.get();
        } catch (CancellationException e) {
            cache.remove(arg, future);
            throw new RuntimeException("网络异常");
        } catch (ExecutionException e) {
            throw new RuntimeException("网络异常");
        }
    }
}
