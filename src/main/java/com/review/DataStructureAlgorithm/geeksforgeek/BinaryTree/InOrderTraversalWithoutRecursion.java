package com.review.DataStructureAlgorithm.geeksforgeek.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversalWithoutRecursion {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		ArrayList<Integer> inorderTraversalResult = new ArrayList<Integer>();
		System.out.println(InOrderTraversalWithoutRecursion(root, inorderTraversalResult));
	}
	
	public static ArrayList<Integer> InOrderTraversalWithoutRecursion(TreeNode A, ArrayList<Integer> inorderTraversalResult) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = A; 
		
		if(A == null) {
			return inorderTraversalResult;
		} 
		
		stack.push(A);
		
		
		while(!stack.isEmpty()) {
			while (currentNode.left != null) {
				stack.push(currentNode.left);
				currentNode = currentNode.left;
			}
			
			inorderTraversalResult.add(currentNode.val);
			System.out.println(currentNode.val);
			
			if(currentNode.right != null) {
				currentNode = currentNode.right;
				stack.pop();
				stack.push(currentNode.right);
			} else {
				stack.pop();
				currentNode = stack.peek();
			}
		}
		
		return inorderTraversalResult;

	}
}
