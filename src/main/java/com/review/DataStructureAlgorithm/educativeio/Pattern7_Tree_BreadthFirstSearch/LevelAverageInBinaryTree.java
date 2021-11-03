package com.review.DataStructureAlgorithm.educativeio.Pattern7_Tree_BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*Given a binary tree, populate an array to represent the averages of all of its levels.*/

public class LevelAverageInBinaryTree {


    public static void main (String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(19);

        root.right.left.right = new TreeNode(5);
        root.right.right.right = new TreeNode(19);

        ArrayList average = findAverage(root);
        System.out.println(average);
    }

    public static ArrayList findAverage(TreeNode root) {
        ArrayList<Double> result = new ArrayList<Double>();
        if (root == null) {
            return result;
        }

        Queue q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelOrderSize = q.size();
            double levelSum = 0;

            for (int i = 0; i < levelOrderSize; i++) {
                TreeNode currentNode = (TreeNode) q.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }

            }
            result.add((levelSum / levelOrderSize));

        }
        return result;
    }
}
