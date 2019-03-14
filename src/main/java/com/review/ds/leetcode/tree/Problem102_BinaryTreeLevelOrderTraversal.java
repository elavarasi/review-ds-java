/**
 * 102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
    }
}
 */

package com.review.ds.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Problem102_BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		
		List<List<Integer>> levelorderresult = levelOrder(root);
		System.out.println(levelorderresult);
	}
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	System.out.println(result);
    	if (root == null) {
    		return result;
    	} else {
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		queue.add(root);
    		//int[] row = new int[root.val];
    		List<Integer> row = new ArrayList<Integer>();
    		row.add(root.val);
    		result.add(row);
    		getlevelOrderTraversal(queue, result);
        	System.out.println(result);
    		return result;
    	}

    }
	
    public static void getlevelOrderTraversal(Queue<TreeNode> queue, List<List<Integer>> result ) {
       	System.out.println(queue.size());
    	if(queue.isEmpty()) {
    		return;
    	}
    	
    	int levelsize = queue.size();
		List<Integer> row = new ArrayList<Integer>();
		
    	while(levelsize>0) {
        	TreeNode currentNode = queue.poll();
        	if(currentNode.left !=null || currentNode.right !=null) {
        		if(currentNode.left != null) {
        			row.add(currentNode.left.val);
            		queue.add(currentNode.left);
            	}
            	
            	if(currentNode.right != null) {
            		row.add(currentNode.right.val);
            		queue.add(currentNode.right);
            	}

        	}
        	levelsize--;
    	}
    	
    	if(!queue.isEmpty()) {
    	 	result.add(row);
    	}
    	getlevelOrderTraversal(queue, result);
    }
	
}
