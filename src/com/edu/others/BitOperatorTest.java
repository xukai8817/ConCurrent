package com.edu.others;

/**
 * @author Administrator
 * 位运算符测试（^ &）
 */
public class BitOperatorTest {

	static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int a = 8;	//     01000
		int b = 24;	//     11000
		
		int c = a ^ b;	// 10000
		int d = a & b;	// 01000
		System.out.println("c=" + c);
		System.out.println("d=" + d);
		
		int e = myTableSizeFor(33);		// 11111
		System.out.println("e=" + e);
		System.out.println(1<<31);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(~1);
	}
	
    static final int tableSizeFor(int cap) {
        int n = cap - 1;	// 11110
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
    static final int myTableSizeFor(int cap) {
    	int n = cap -1;
    	for (int i = 1; i <=16; i *= 2) {
    		n |= n >>> i;
		}
    	return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
