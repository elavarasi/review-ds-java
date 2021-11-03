//package com.review.ds.gaylee.TreesAndGraph;
//
///* Find in order successor of BST */
//
//
//public class InOrderSuccessorOfBST {
//
//    public static void main(String args[]) {
//        Node root = new Node(20);
//        root.leftChild = new Node()
//    }
//
//
//
//}
//
//class BinaryTree {
//    static Node head;
//
//    // Given a binary search tree and a number, insert a new node with the given number in the correct place in the tree
//    // Return the new root pointer which the caller can use next
//    Node insert(Node node, int data) {
//        if (node == null) {
//            return (new Node(data));
//        } else {
//            Node temp = null;
//
//            if (data <= node.nodeVal) {
//                temp = insert(node.leftChild, data);
//                node.leftChild = temp;
//                temp.parent = node;
//            } else {
//                temp = insert(node.rightChild, data);
//                node.rightChild = temp;
//                temp.parent = node;
//            }
//            return node;
//        }
//    }
//
//
//}
