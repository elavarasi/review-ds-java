package com.review.DataStructureAlgorithm.leetcode.tree;

public class Problem110_BalancedBinaryTree {
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		
		System.out.println(isBalanced(root));
	}
	
    public static boolean isBalanced(TreeNode node) {
    	if(node == null) {
    		return true;
    	}
    	
    	int leftTreeHeight = height(node.left); 
    	int rightTreeHeight = height(node.right);
    	
    	if((Math.abs(leftTreeHeight-rightTreeHeight) <= 1) && (isBalanced(node.left) && isBalanced(node.right))) {
    		return true;
    	}
    	
		return false;
        
    }
    
	private static int height(TreeNode node) {
		int heightOfTree = 0;
		int leftNodeHeight = 0;
		int rightNodeHeight = 0;
		
		if(node == null) {
			return 0;
		}
		
		if(node.left != null) {
			leftNodeHeight = height(node.left);
		}
		if(node.right !=null ) {
			rightNodeHeight = height(node.right);	
		}
		
		if(leftNodeHeight > rightNodeHeight) {
			heightOfTree = 1 + leftNodeHeight;
		} else {
			heightOfTree = 1 + rightNodeHeight;
		}
			
		return heightOfTree;
	}
	

}
