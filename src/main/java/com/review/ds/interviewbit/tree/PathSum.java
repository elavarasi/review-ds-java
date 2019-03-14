/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
package com.review.ds.interviewbit.tree;

public class PathSum {
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
		
		int expectedSum = 18;
		System.out.println(hasPathSum(root, expectedSum));
		
	}
	
    public static boolean hasPathSum(TreeNode A, int B) {
    	
        if(A == null) {
            return false;
        }
    	
    	return hasExpectedPathSum(A, A.val, B);
    	
    }
	
    
    public static boolean hasExpectedPathSum(TreeNode N, int pathSum, int expectedSum) {
    	if(N.left == null && N.right == null) {
    		if(pathSum == expectedSum) {
    			return true;
    		}
    	}
    	
    	boolean leftSubTreeHasExpectedPath = false;
    	boolean righSubTreeHasExpectedPath = false;
    	
    	if(N.left != null) {
        	leftSubTreeHasExpectedPath = hasExpectedPathSum(N.left, pathSum + N.left.val, expectedSum);	
        	
        	if(leftSubTreeHasExpectedPath) {
        		return true;
        	}    		
    	}

    	if(N.right != null) {
        	righSubTreeHasExpectedPath = hasExpectedPathSum(N.right, pathSum + N.right.val, expectedSum);	
        	
        	if(righSubTreeHasExpectedPath) {
        		return true;
        	}    		
    	}

		return false;
    }
    
}
