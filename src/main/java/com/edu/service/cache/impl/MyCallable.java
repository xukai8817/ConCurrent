package com.edu.service.cache.impl;

import com.edu.service.cache.Computable;
import java.util.concurrent.Callable;

public class MyCallable<A, V> implements Callable<V> {

    private A arg;

    private Computable<A, V> c;

    public MyCallable(Computable c, A arg) {
        this.c = c;
        this.arg = arg;
    }

    @Override
    public V call() throws Exception {
        return c.compute(arg);
    }
}
