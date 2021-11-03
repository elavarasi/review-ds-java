package com.review.DataStructureAlgorithm.educativeio.Pattern8_TreeDepthFirstSearch;

/*
Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsForASum {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("Three has path:"  + CountAllPathSum(root, 11));

    }

    private static int CountAllPathSum(TreeNode root, int s) {
        List<Integer> currentPath = new ArrayList<>();
        return countPathRecursive(root, s, currentPath);
    }

    private static int countPathRecursive(TreeNode currentNode, int s, List<Integer> currentPath) {
        if (currentNode == null) {
            return 0;
        }

        currentPath.add(currentNode.val);
        int pathSum = 0; int pathCount = 0;

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while(pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();

            if (pathSum == s) {
                pathCount ++;
            }
        }

        pathCount += countPathRecursive(currentNode.left, s, currentPath);
        pathCount += countPathRecursive(currentNode.right, s, currentPath);

        currentPath.remove(currentPath.size() -1);

        return pathCount;

    }
}
