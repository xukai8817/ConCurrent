package com.edu.node;

import java.util.ArrayList;
import java.util.List;

public class IteratorNode {


	public List<Node> iterator(Node root) {
		if (root == null)
			return null;
		List<Node> list = new ArrayList<Node>();
		for (Node node : root.getChildrens()) {
			list.addAll(iterator(node));
		}
		return list;
	}
	
	public static class Node{
		List<Node> childrens;

		public List<Node> getChildrens() {
			return childrens;
		}

		public void setChildrens(List<Node> childrens) {
			this.childrens = childrens;
		}
		
	}
}
