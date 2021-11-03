package com.review.DataStructureAlgorithm.educativeio.Pattern7_Tree_BreadthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(7);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(9);

        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(12);

        root.right.left.right = new TreeNode(6);

        List<List> result = getZigZagTraversal(root);
        System.out.println(result);
    }

    private static List<List> getZigZagTraversal(TreeNode root) {
        List<List> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int levelOrderSize = queue.size();
            LinkedList levelItems = new LinkedList();
            level ++;
            for (int i = 0; i < levelOrderSize; i++) {
                TreeNode currentNode = queue.poll();

                if(level % 2 == 0) {
                    levelItems.add(0, currentNode.val);

                } else {
                    levelItems.add(currentNode.val);
                }

                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(levelItems);
        }

        return result;
    }
}
