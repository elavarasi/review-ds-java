package com.review.DataStructureAlgorithm.gaylee.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepth {
    public static void main(String args[]) {
        Node root = new Node(5);
        root.leftChild = new Node(6);
        root.rightChild = new Node(8);

        root.leftChild.leftChild = new Node(6);
        root.leftChild.rightChild = new Node(9);

        root.rightChild.leftChild = new Node(7);
        root.rightChild.rightChild = new Node(8);

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        DepthFirstBuildListOfDepth(result, root, 0);

        List<ArrayList<Node>> result1 = BreadthFirstBuildListOfDepth(root);
        System.out.println(result1);
    }

    public static void DepthFirstBuildListOfDepth(ArrayList<List<Integer>> result, Node node, int level) {
        if (node == null) {
            return;
        }

        if (result.size() == level) {
            // New entry
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(node.getNodeVal());
            result.add(newList);
        } else {
            List<Integer> newList = result.get(level);
            newList.add(node.getNodeVal());
        }

        DepthFirstBuildListOfDepth(result, node.leftChild, level+1);
        DepthFirstBuildListOfDepth(result, node.rightChild, level+1);
    }

    public static List<ArrayList<Node>> BreadthFirstBuildListOfDepth(Node node) {
        List<ArrayList<Node>> result = new LinkedList<ArrayList<Node>>();

        ArrayList<Node> current = new ArrayList<>();
        if (node != null) {
            current.add(node);
        }

        while(!current.isEmpty()) {
            result.add(current);
            ArrayList<Node> parent = current;
            current = new ArrayList<>();

            for (Node eachParent : parent) {
                if (eachParent.leftChild != null) {
                    current.add(eachParent.leftChild);
                }
                if (eachParent.rightChild != null) {
                    current.add(eachParent.rightChild);
                }
            }
        }

        return result;
    }
}
