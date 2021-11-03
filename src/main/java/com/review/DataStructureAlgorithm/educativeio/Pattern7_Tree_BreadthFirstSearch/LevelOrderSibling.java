package com.review.DataStructureAlgorithm.educativeio.Pattern7_Tree_BreadthFirstSearch;
/*
Connect All Level Order Siblings (medium) #
Given a binary tree, connect each node with its level order successor.
The last node of each level should point to the first node of the next level.
*/

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSibling {

    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelOrderSize = q.size();

            for (int i = 0; i < levelOrderSize; i++) {
                TreeNode currentNode = (TreeNode) q.poll();

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }

                if (!q.isEmpty()) {
                    currentNode.next = (TreeNode) q.peek();
                } else {
                    currentNode.next = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        LevelOrderSibling.connect(root);
        root.printTree();
    }
}
