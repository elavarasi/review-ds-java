//package com.review.ds.educativeio.Algorithms.GreedyAlgorithm;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class Coloring {
//
//    public static void main(String[] args) {
//        Graph g1 = new Graph(5);
//        g1.addEdge(0, 1);
//        g1.addEdge(0, 2);
//        g1.addEdge(1, 2);
//        g1.addEdge(1, 3);
//        g1.addEdge(2, 3);
//        g1.addEdge(3, 4);
//
//        Coloring.greedyColoring(g1);
//        System.out.println();
//
//        Graph g2 = new Graph(5);
//        g2.addEdge(0, 1);
//        g2.addEdge(0, 2);
//        g2.addEdge(1, 2);
//        g2.addEdge(1, 4);
//        g2.addEdge(2, 4);
//        g2.addEdge(4, 3);
//        Coloring.greedyColoring(g2);
//    }
//
//
//    public static void greedyColoring(Graph g) {
//        int numofVertices = g.getVertices();
//        g.getAdj();
//        int[] result = new int[numofVertices];
//
//        Arrays.fill(result, -1);
//
//        Map<Integer, List<Integer>> colorMap = new HashMap<>();
//        // For each vertices find the available color
//        for (int eachVertice = 0; eachVertice < numofVertices; eachVertice ++) {
//            // Find a suitable color
//            if (colorMap.isEmpty()) {
//                colorMap.put(new Integer(0), Arrays.asList(eachVertice));
//                result[0] = 0;
//            } else {
//                // Find if there is a suitable color in the map
//                for (Integer eachColorInMap : colorMap.keySet()) {
//                    List<Integer> verticesForTheColor = colorMap.get(eachColorInMap);
//                    if (! verticesForTheColor.contains(eachVertice)) {
//                        colorMap.put(eachColorInMap, Arrays.asList(eachVertice));
//                        result[eachVertice] = eachColorInMap;
//                    }
//                }
//            }
//        }
//
//        // write your code here
//        for (int i = 0; i < numofVertices; i++) {
//            System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
//        }
//    }
//}