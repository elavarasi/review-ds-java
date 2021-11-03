package com.review.DataStructureAlgorithm.educativeio.Pattern7_Tree_BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static int getMinimumDepthOfBinaryTree(TreeNode root) {
        int depth = 0;

        if (root == null) {
            return depth;
        }

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()) {
            depth ++;
            int levelOrderSize = q.size();
            for (int i=0; i<levelOrderSize; i++) {
                TreeNode currentNode = q.poll();

                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }

        return depth;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(89);

        int depth = getMinimumDepthOfBinaryTree(root);
        System.out.println(depth);

    }

}
