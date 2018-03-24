package com.edu.service.cache;

import java.util.concurrent.ExecutionException;

/**
 * @author xukai
 *
 */
public interface Computable<A, V> {

	V compute(A arg) throws InterruptedException;
}
