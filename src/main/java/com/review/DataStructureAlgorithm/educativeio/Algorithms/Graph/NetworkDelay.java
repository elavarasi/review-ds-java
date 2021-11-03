package com.review.DataStructureAlgorithm.educativeio.Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {
        public static void main(String args[]) {
//            int[][] input = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
//            int n = 4;
//            int k = 2;

//            int[][] input = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
//            int n = 3;
//            int k = 1;

//            int[][] input = {{1, 2, 1}};
//            int n = 2;
//            int k = 2;

            int[][] input = {{1, 2, 1}, {2, 3, 2}, {1, 3, 1}};
            int n = 3;
            int k = 2;

            int result = networkDelayTime(input, n, k);
            System.out.println(result);
        }

        public static int networkDelayTime(int[][] times, int n, int k) {

            int[] distance = new int[n + 1];
            int[] path = new int[n + 1];
            Arrays.fill(distance, -1);

            List<Pairs>[] adjMatrix = new ArrayList[n + 1];

            for (int i = 0; i < times.length ; i++) {
                int[] data = times[i];
                int start = data[0];
                int end = data[1];
                int weight = data[2];

                List<Pairs> adjacencies = (adjMatrix[start] == null) ? new ArrayList() : adjMatrix[start];
                adjacencies.add(new Pairs(end, weight));
                adjMatrix[start] =  adjacencies;
            }

            PriorityQueue<Pairs> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            queue.add(new Pairs(k, 0));
            distance[k] = 0;
            path[k] = k;
            int result = -1;

            while (!queue.isEmpty()) {
                Pairs currentPair = queue.poll();
                int startVertex = currentPair.vertex;
                int startWeight = currentPair.weight;

                List<Pairs> adj = adjMatrix[startVertex];
                if (adj != null) {
                    for (Pairs eachPair : adj) {
                        int destinationVertex = eachPair.vertex;
                        int weightToDestination = eachPair.weight;
                        int totalWeightFromThisSourcetoReachDestination = startWeight + weightToDestination;

                        if (distance[destinationVertex] == -1) {
                            distance[destinationVertex] = totalWeightFromThisSourcetoReachDestination;
                            path[destinationVertex] = startVertex;
                            queue.add(new Pairs(destinationVertex, distance[destinationVertex]));
                        } else {
                            if (distance[destinationVertex] > totalWeightFromThisSourcetoReachDestination) {
                                distance[destinationVertex] = totalWeightFromThisSourcetoReachDestination;
                                path[destinationVertex] = startVertex;
                                queue.add(new Pairs(destinationVertex, distance[destinationVertex]));
                            }
                        }

                    }
                }
            }
            distance[k] = -1;
            int allNodesReached = n+1;
            for (int eachdistance : distance) {
                result = Math.max(result, eachdistance);
                if (eachdistance != -1) {
                    allNodesReached--;
                }
            }
            if (allNodesReached > 2) {
                return -1;
            }
            return result;

        }
}

class Pairs {

    int vertex;
    int weight;

    Pairs(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

}