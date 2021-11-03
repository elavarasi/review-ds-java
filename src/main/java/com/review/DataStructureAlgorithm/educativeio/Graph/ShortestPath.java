package com.review.DataStructureAlgorithm.educativeio.Graph;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ShortestPath {
    public static void main(String args[]) {
        int noOfVertices = 7;
        int startVertex = 2;

        List<Integer>[] adj = new ArrayList[noOfVertices];

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        adj[0] = list;

        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        adj[1]  = list;

        Pair<String, Integer> pair = new Pair("ela", 100);




    }



}
