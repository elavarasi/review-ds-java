package com.review.DataStructureAlgorithm.leetcode.tree.dp.wordbreak;

public class MaxSumPathInBinaryTree {
    public static void main (String args[]) {
        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-1);

//        root.left.left = new TreeNode(-10);
//        root.left.right = new TreeNode(-5);
//
//        root.right.left = new TreeNode(-5);
//        root.right.right = new TreeNode(30);

        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        System.out.println(findMaxPathSum(root, res));

    }

    private static int findMaxPathSum(TreeNode root, Res res) {
        maxPathSum(root, res);
        return res.val;
    }


    public static int maxPathSum(TreeNode A, Res res) {
        if(A == null) {
            return 0;
        }

        int maxPathSumOfLeftTree = maxPathSum(A.left, res);
        int maxPathSumOfRightTree = maxPathSum(A.right, res);
        int rootNodeValue = A.val;

        int maxSingle = Math.max(Math.max(maxPathSumOfLeftTree, maxPathSumOfRightTree) + rootNodeValue, rootNodeValue);

        int maxTop = Math.max(maxSingle, maxPathSumOfLeftTree + maxPathSumOfRightTree + rootNodeValue);

        res.val = Math.max(res.val, maxTop);

        return maxSingle;

    }
}

class Res {
    public int val;
}

// public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) {
//        val = x;
//        left=null;
//        right=null;
//    }
//}