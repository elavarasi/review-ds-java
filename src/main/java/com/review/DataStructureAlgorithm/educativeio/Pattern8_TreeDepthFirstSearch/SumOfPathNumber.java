package com.review.DataStructureAlgorithm.educativeio.Pattern8_TreeDepthFirstSearch;

public class SumOfPathNumber {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        int sumOfAllPath = 0;
        System.out.println(getSumOfAllPath(root, sumOfAllPath));
    }

    private static int getSumOfAllPath(TreeNode currentNode, int sumOfAllPath) {
        if (currentNode == null) {
            return 0;
        }

        // calculate path sum
        sumOfAllPath = 10 * sumOfAllPath + currentNode.val;

        if (currentNode.left == null && currentNode.right == null) {
            return sumOfAllPath;
        }

        return getSumOfAllPath(currentNode.left, sumOfAllPath) + getSumOfAllPath(currentNode.right, sumOfAllPath);
    }
}
