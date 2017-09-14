package com.edu.chapter.five;

/**
 * @author xukai
 *
 */
public interface Computable<A, V> {

	V compute(A arg) throws InterruptedException;
}
