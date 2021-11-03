package com.review.DataStructureAlgorithm.educativeio.Pattern7_Tree_BreadthFirstSearch;
/*
Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode (int x) {
        val = x;
        left = null;
        right = null;
        next = null;
    }

    // Tree Traversal using next pointer
    public void printTree() {
        TreeNode current = this;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
    }

}


public class LevelOrderTraversal {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(22);

        List<ArrayList> result = new ArrayList<>();
        result = getLevelOrderTraversal(root);
        System.out.println(result);
    }

    public static List<ArrayList> getLevelOrderTraversal(TreeNode root) {
        List<ArrayList> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ArrayList levelArray = new ArrayList<>();
            int levelSize = queue.size();

            for (int i=0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelArray.add(currentNode.val);
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }

            result.add(levelArray);
        }

        return result;
    }
}
