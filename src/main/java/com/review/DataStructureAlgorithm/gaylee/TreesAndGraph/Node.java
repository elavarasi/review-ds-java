package com.review.DataStructureAlgorithm.gaylee.TreesAndGraph;

public class Node {
    int nodeVal;
    Node leftChild;
    Node rightChild;
    Node parent;

    Node (int nodeVal) {
        this.nodeVal = nodeVal;
    }

    public int getNodeVal() {
        return nodeVal;
    }

    public void setNodeVal(int nodeVal) {
        this.nodeVal = nodeVal;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setParent(Node parent) { this.parent = parent; };

    public Node getParent() { return this.parent; };


}
