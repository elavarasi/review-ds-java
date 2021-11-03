/**
 * Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
 */

package com.review.DataStructureAlgorithm.interviewbit.tree;

public class BalancedBinaryTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(8);
		root.left.right.right.right = new TreeNode(10); //making tree imbalanced
		root.left.right.right.right = new TreeNode(11);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		System.out.println(bbt.isBalanced(root));
	}
	
    public int isBalanced(TreeNode node) {
    	if(node == null) {
    		return 1;
    	}
    	
    	int leftTreeHeight = height(node.left); 
    	int rightTreeHeight = height(node.right);
    	
    	if((Math.abs(leftTreeHeight-rightTreeHeight) <= 1) && (isBalanced(node.left) == 1 && isBalanced(node.right) == 1)) {
    		return 1;
    	}
    	
		return 0;
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
