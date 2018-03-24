package com.edu.service.cache;

import com.edu.service.cache.Computable;
import java.math.BigInteger;

public class MyThread implements Runnable {

    Computable<String, BigInteger> m;

    String str;

    public MyThread(Computable<String, BigInteger> m, String str) {
        this.m = m;
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println("start");
        try {
            System.out.println(Thread.currentThread().getId() + ":compute result = " + m.compute(str));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

}
