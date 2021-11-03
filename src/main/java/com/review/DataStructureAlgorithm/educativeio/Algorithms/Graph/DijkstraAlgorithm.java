package com.review.DataStructureAlgorithm.educativeio.Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static void main(String args[]) {
        int noOfVertices = 5;
        int startVertex = 0;

        List<Pair<Integer, Integer>>[] adj = new ArrayList[noOfVertices];

        List<Pair<Integer, Integer>> list = new ArrayList<>();
        list.add(new Pair(1, 4));
        list.add(new Pair(2, 1));
        adj[0] = list;

        list = new ArrayList<>();
        list.add(new Pair(4,4));
        adj[1] = list;

        list = new ArrayList<>();
        list.add(new Pair(1, 2));
        list.add(new Pair(3, 4));
        adj[2] = list;

        list = new ArrayList<>();
        list.add(new Pair(4, 4));
        adj[3] = list;

        list = new ArrayList<>();
        adj[4] = list;

        int[] path = new int[noOfVertices];
        int[] distance = new int[noOfVertices];

        Arrays.fill(distance, -1);

        distance[startVertex] = 0;
        path[startVertex] = startVertex;

        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> a.weight - b.weight);
        q.add(new Pair(startVertex, 0));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> vertexPair = q.poll();
            int vertex = vertexPair.vertex;
            List<Pair<Integer, Integer>> adjVertices = adj[vertex];

            for (Pair<Integer, Integer> adjPair : adjVertices) {
                int adjVertex = adjPair.vertex;
                int weight = adjPair.weight;

                int newDistance = distance[vertex] + weight;
                if (distance[adjVertex] == -1 || distance[adjVertex] > newDistance) {
                    distance[adjVertex] = newDistance;
                    path[adjVertex] = vertex;
                    q.add(new Pair<>(adjVertex, distance[adjVertex]));
                }
            }

        }

        System.out.println("Distance from" + (char)(startVertex + 'A') + " :");
        for(int i = 0; i < noOfVertices; i++) {
            System.out.println("Distance to" + (char)(i + 'A') + " is " + distance[i]);
            System.out.println(" from path " + (char)(path[i] + 'A'));
        }


    }
}

class Pair<I extends Number, I1 extends Number> {
    int vertex;
    int weight;

    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}