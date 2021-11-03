/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

1) Initialize list of BSTs as empty.
2) For every number i where i varies from 1 to N, do following
......a)  Create a new node with key as 'i', let this node be 'node'
......b)  Recursively construct list of all left subtrees.
......c)  Recursively construct list of all right subtrees.
3) Iterate for all left subtrees
   a) For current leftsubtree, iterate for all right subtrees
        Add current left and right subtrees to 'node' and add
        'node' to list.
 */

package com.review.DataStructureAlgorithm.leetcode.tree.dp.wordbreak;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {

    public static void main(String args[]) {
        int n = 3;


        List<TreeNode> result = uniqueBinarySearchTree(1, n);

        for(int i = 0; i < result.size(); i++) {
            preorder(result.get(i));
            System.out.println();
        }
    }

    private static List<TreeNode> uniqueBinarySearchTree(int start, int end) {

        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }


        for (int rootValue = start; rootValue <= end; rootValue ++) {
            List<TreeNode> ls = uniqueBinarySearchTree(start, rootValue-1);
            List<TreeNode> rs = uniqueBinarySearchTree(rootValue + 1, end);

            for (TreeNode l : ls) {
                for (TreeNode r: rs) {
                    TreeNode current = new TreeNode(rootValue);
                    current.left = l;
                    current.right = r;
                    result.add(current);
                }
            }
        }

        return result;
    }

    static void preorder(TreeNode node) {
        if(node != null) {
            System.out.println(node.val + " ");
            preorder(node.left);
            preorder(node.right);
        }

    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) {this.val = val;};
}