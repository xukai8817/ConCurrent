package com.edu.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * HashMap中的数组table的length必定是2的幂次方
 */
public class MapTableSize {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>(3);
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		System.out.println(map);
		/**
		 * index
		 * 0	null	
		 * 1	a-a
		 * 2	b-b	
		 * 3	c-c
		 */
	}
	
}
