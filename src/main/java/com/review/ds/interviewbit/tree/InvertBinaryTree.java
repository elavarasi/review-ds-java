/**
 * Given a binary tree, invert the binary tree and return it. 
Look at the example for more details.

Example : 
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4
 */

package com.review.ds.interviewbit.tree;

public class InvertBinaryTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		TreeNode invertedTreeRoot = invertTree(root);
		System.out.println(invertedTreeRoot);
		
		//print a tree;
		
	}
	
    public static TreeNode invertTree(TreeNode A) {
    	if(A == null) {
    		return null;
    	}
    	
    	TreeNode node = new TreeNode(A.val);
    	buildInvertedTree(A, node);
		return node;
    }
    
    public static void buildInvertedTree(TreeNode currentTreeNode, TreeNode invertedTreeNode) {
    	if(currentTreeNode.right != null) {
    		invertedTreeNode.left = new TreeNode(currentTreeNode.right.val);
    		buildInvertedTree(currentTreeNode.right, invertedTreeNode.left);
    	}
    	
    	if(currentTreeNode.left != null) {
    		invertedTreeNode.right = new TreeNode(currentTreeNode.left.val);
    		buildInvertedTree(currentTreeNode.left, invertedTreeNode.right);
    	}
    }
}
