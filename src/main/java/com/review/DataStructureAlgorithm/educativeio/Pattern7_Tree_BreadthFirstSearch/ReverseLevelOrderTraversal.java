package com.review.DataStructureAlgorithm.educativeio.Pattern7_Tree_BreadthFirstSearch;
/*
Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest level comes first.
You should populate the values of all nodes in each level from left to right in separate sub-arrays.
 */
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {


    public static List<List<Integer>> doReverseOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        // First check if root is null
        if (root == null) {
            return result;
        }

        // Maintain Queue to get the items in level. Push root to the queue
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        // Until Queue is not empty, get each item on queue, add its val to level array list, add its children back to queue and remove the node from the queue
        while(!queue.isEmpty()) {
            int levelOrderSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelOrderSize);
            for (int i = 0; i < levelOrderSize; i++) {
                TreeNode currentNode = queue.poll();

                //Add the node to current level
                currentLevel.add(currentNode.val);

                // Insert the children of currentNode to the queue
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(0, currentLevel);
        }

        return result;
    }


    public static void main (String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(89);

        List<List<Integer>> result = doReverseOrderTraversal(root);
        System.out.println(result);

    }

}
