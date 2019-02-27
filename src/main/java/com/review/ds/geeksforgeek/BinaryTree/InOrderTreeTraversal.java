/**
 * inorderTraversal  - with recursion
 */



package com.review.ds.geeksforgeek.BinaryTree;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class InOrderTreeTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		ArrayList<Integer> inorderTraversalResult = new ArrayList<Integer>();
		System.out.println(inorderTraversal(root, inorderTraversalResult));
	}
	
	
	public static ArrayList<Integer> inorderTraversal(TreeNode A, ArrayList<Integer> inorderTraversalResult) {
		// If tree is empty then return empty result;
		if (A == null) {
			return inorderTraversalResult;
		}
		
		// If the node has a left node then visit the left node
		if(A.left != null) {
			inorderTraversal(A.left, inorderTraversalResult);
		}
		
		// Print the current node
		System.out.println(A.val);
		System.out.println(inorderTraversalResult);
		inorderTraversalResult.add(A.val);
		
		// Visit all the right nodes
		if(A.right != null) {
			inorderTraversal(A.right, inorderTraversalResult);
		}
		return inorderTraversalResult;
	}
	
}
