package com.edu.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapSource {

	static Node<Integer>[] table;
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		System.out.println(map);

		test();
	}

	public static void test() {
		Node<Integer>[] newArray = table;
		System.out.println(newArray == null);
		Node<Integer>[] origin = new Node[2];
		origin[0] = new Node<>(1);
		
		table = origin;
		System.out.println(newArray == origin);
	}
	
	static class Node<T> {
		int value;

		public Node(int value) {
			super();
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
	
}
