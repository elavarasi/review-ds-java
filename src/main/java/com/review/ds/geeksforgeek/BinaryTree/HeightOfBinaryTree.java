package com.review.ds.geeksforgeek.BinaryTree;

public class HeightOfBinaryTree {
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.left.left = new Node(4);
		
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.right.right = new Node(9);
		
		int heightOfTree = findHeightOfBinaryTree(tree.root);
		System.out.println(heightOfTree);
	}
	
	public static int findHeightOfBinaryTree(Node node) {
		int heightOfTree = 0;
		int leftNodeHeight = 0;
		int rightNodeHeight = 0;
		
		if(node == null) {
			return 0;
		}
		
		if(node.left != null) {
			leftNodeHeight = findHeightOfBinaryTree(node.left);
		}
		if(node.right !=null ) {
			rightNodeHeight = findHeightOfBinaryTree(node.right);	
		}
		
		if(leftNodeHeight > rightNodeHeight) {
			heightOfTree = 1 + leftNodeHeight;
		} else {
			heightOfTree = 1 + rightNodeHeight;
		}
			
		return heightOfTree;
	}
	
}

