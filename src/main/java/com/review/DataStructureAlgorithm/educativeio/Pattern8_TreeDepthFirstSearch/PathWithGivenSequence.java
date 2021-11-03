package com.review.DataStructureAlgorithm.educativeio.Pattern8_TreeDepthFirstSearch;
/*
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 */
public class PathWithGivenSequence {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(6);

        int[] sequence = new int[] {1,8,9};
        System.out.println(pathFound(root, sequence));

        int[] sequence1 = new int[] {1,8,0};
        System.out.println(pathFound(root, sequence1));

    }

    public static boolean pathFound(TreeNode root, int[] sequence) {
        if (root == null) {
            return sequence.length == 0;
        }
        return isPathFound(root, sequence, 0);
    }

    public static boolean isPathFound(TreeNode node, int[] sequence, int sequenceIndex) {
        if (node == null) {
            return true;
        }

        if (sequenceIndex >= sequence.length || node.val != sequence[sequenceIndex]) {
            return false;
        }

        // if the current node is a leaf, add it is the end of the sequence, we have found a path!
        if (node.left == null && node.right == null && sequenceIndex == sequence.length - 1)
            return true;

        return isPathFound(node.left, sequence, sequenceIndex+1) || isPathFound(node.right, sequence, sequenceIndex+1);
    }
}
