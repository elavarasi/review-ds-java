package com.review.DataStructureAlgorithm.educativeio.Algorithms.GreedyAlgorithm;

import java.util.*;

class Graph {
 int vertices;
 LinkedList[] adjacencyList;

 Graph(int vertices) {
     this.vertices = vertices;
     adjacencyList = new LinkedList[vertices];

     for (int i = 0; i < vertices; i++) {
         adjacencyList[i] = new LinkedList<>();
     }
 }

 void addEdge(int source, int destination) {
     adjacencyList[source].add(destination);
 }

 int getVertices() {
     return vertices;
 }

 LinkedList[] getAdjacencyList() {
     return adjacencyList;
 }

 public void printGraph() {

 }


};
