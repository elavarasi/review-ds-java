package com.review.DataStructureAlgorithm.educativeio.Pattern8_TreeDepthFirstSearch;
/*Given a binary tree and a number ‘S’,
 find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePathSum {

    public static boolean hasPath (TreeNode root, int sum) {
        // If node is null, no more hasPath can be done on this path, so return false
        if(root == null) {
            return false;
        }

        // If the current node is leaf and we have seen the sum also matches then we found a path
        if(root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        // Recursively check
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + BinaryTreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + BinaryTreePathSum.hasPath(root, 16));
    }
}
