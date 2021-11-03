package com.review.DataStructureAlgorithm.educativeio.Pattern8_TreeDepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
public class AllPathsForASum {


    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentPath = new ArrayList<Integer>();

        findAllPaths(root, 12, currentPath, result);
        System.out.println(result);
    }


    static void findAllPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        // Add current node to the path
        currentPath.add(root.val);

        // It is a leaf node and val = sum, this path needs to be added to all Paths
        if(root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            // If not a leaf node then dfs on both left and right nodes
            findAllPaths(root.left, sum - root.val, currentPath, allPaths);
            findAllPaths(root.right, sum - root.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack
        // We need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() -1);

    }

}
