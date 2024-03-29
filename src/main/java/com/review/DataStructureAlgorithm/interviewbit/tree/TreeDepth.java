package com.review.DataStructureAlgorithm.interviewbit.tree;


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class TreeDepth {
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		
		int heightOfTree = maxDepth(root);
		System.out.println(heightOfTree);

	}

	private static int maxDepth(TreeNode node) {
		int heightOfTree = 0;
		int leftNodeHeight = 0;
		int rightNodeHeight = 0;
		
		if(node == null) {
			return 0;
		}
		
		if(node.left != null) {
			leftNodeHeight = maxDepth(node.left);
		}
		if(node.right !=null ) {
			rightNodeHeight = maxDepth(node.right);	
		}
		
		if(leftNodeHeight > rightNodeHeight) {
			heightOfTree = 1 + leftNodeHeight;
		} else {
			heightOfTree = 1 + rightNodeHeight;
		}
			
		return heightOfTree;
	}

}