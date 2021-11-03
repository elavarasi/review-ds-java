package com.review.DataStructureAlgorithm.educativeio.Algorithms.Graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class CountNodes {
    List
    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(2,4);

        int number = numberOfNodesInGivenLevel(g, 0, 2);
        System.out.println(number);
    }

    public static int numberOfNodesInGivenLevel(Graph g, int source, int level) {
        int count = 0; //count initialized to zero
        int num_of_vertices = g.getVertices(); //getVertices given in Graph.java file

        // Write - Your - Code
        boolean[] visited = new boolean[num_of_vertices];
        int currentLevel = 0;
        LinkedList[] adjacencies = g.getAdj();

        Queue<Integer> q = new PriorityQueue<>();
        q.add(source);
        visited[source] = true;
        count = q.size();
        currentLevel ++;

        while (!q.isEmpty() && currentLevel < level) {
            for (int i = 0; i < count; i++) {
                int top = q.poll();
                LinkedList<Integer> currentNodeAdj = adjacencies[top];
                Iterator<Integer> itr = currentNodeAdj.iterator();

                while(itr.hasNext()) {
                    int eachAdjacency = itr.next();
                    if(!visited[eachAdjacency]) {
                        q.add(eachAdjacency);
                        visited[eachAdjacency] = true;
                    }
                }
            }
            count = q.size();
            currentLevel++;
        }


        return count;
    }
}