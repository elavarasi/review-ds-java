/**
 * Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.
     10
   /   \
  5     40
 /  \      \
1    7      50
 */

package com.review.ds.interviewbit.tree;

public class BSTFromPreorderTraversal {
	public static void main(String args[]) {
		int pre[] = {10,5,1,7,40,50};
		TreeNode node = getBSTfromPreorderTraverasal(pre);
		printInordertree(node);
	}
	
	static TreeNode getBSTfromPreorderTraverasal(int[] pre) {
		return getGST(pre, 0, 0, pre.length);
		
	}
	
	static TreeNode getGST(int[] pre, int index, int low, int high ) {
		if(low > high) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[index]);
		
		int i;
		for(i=low; i<high; i++ ) {
			if (pre[i] > pre[index]) {
				break;	
			}
		}
		
		index ++;
		
		//build left tree
		root.left = getGST(pre, index, index+1, i-1 );
		
		//build right tree
		root.right = getGST(pre, index, i+1, high);
		return root;
	}
	
	static void printInordertree(TreeNode node) {
		if(node == null) {
			return;
		}
		printInordertree(node.left);
		System.out.println(node.val);
		printInordertree(node.right);
	}
}
