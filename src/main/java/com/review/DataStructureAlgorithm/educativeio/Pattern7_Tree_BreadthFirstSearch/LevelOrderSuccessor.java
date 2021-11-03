package com.review.DataStructureAlgorithm.educativeio.Pattern7_Tree_BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
/* Given a binary tree and a node, find the level order successor of the given node in the tree.
The level order successor is the node that appears right after the given node in the level order traversal.*/

public class LevelOrderSuccessor {
    public static TreeNode getLevelOrderSuccessor(TreeNode root, int key) {
        TreeNode successorVal = null;

        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelOrderSize = q.size();
            for (int i=0; i<levelOrderSize; i++) {
                TreeNode currentNode = q.poll();

                if (currentNode.val == key) {
                    if(!q.isEmpty()){
                        return q.peek();
                    } else if (currentNode.left != null) {
                            return currentNode.left;
                    } else if (currentNode.right != null) {
                            return currentNode.right;
                    } else {
                        return null;
                    }

                }

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
        return successorVal;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(89);
        int key = 89;
        System.out.println(getLevelOrderSuccessor(root, key) != null ? getLevelOrderSuccessor(root, key).val : null);


    }

}
