package com.edu.service.cache;

import com.edu.service.cache.impl.Memoizer;
import com.edu.service.cache.impl.Memoizer1;
import java.math.BigInteger;

/**
 * @author xukai
 * 测试多线程环境下效率
 */
public class MemoizerTest {

    public static void main(String[] args) {
        Computable<String, BigInteger> c = new Computable<String, BigInteger>() {

            @Override
            public BigInteger compute(String arg) throws InterruptedException {
                Thread.sleep(1000L);
                return new BigInteger(arg);
            }

        };
        Computable<String, BigInteger> cache = new Memoizer<>(c);

        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(cache, ("111"))).start();
        }
    }

}
