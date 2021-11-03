package com.review.DataStructureAlgorithm.geeksforgeek.BinaryTree;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int item) {
		data = item;
		left = null;
		right = null;
	}
}


class BinaryTree {
	Node root;
	
	BinaryTree(int key) {
		root = new Node(key);
	}
	
	BinaryTree() {
		root = null;
	}
	
	public void printTree(){
		
	}
}

public class BinaryTreeImplementation {
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(5);
	}
}



