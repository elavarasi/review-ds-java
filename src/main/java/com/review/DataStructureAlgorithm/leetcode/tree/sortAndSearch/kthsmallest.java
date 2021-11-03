package com.review.DataStructureAlgorithm.leetcode.tree.sortAndSearch;

import java.util.Comparator;
import java.util.PriorityQueue;
class MyHeapNode {
    int row;
    int column;
    int value;

    public MyHeapNode(int v, int r, int c) {
        this.value = v;
        this.row = r;
        this.column = c;
    }

    public int getValue() {
        return this.value;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}

class MyHeapComparator implements Comparator<MyHeapNode> {

    @Override
    public int compare(MyHeapNode o1, MyHeapNode o2) {
        return o1.value - o2.value;
    }
}


public class kthsmallest {

    public static void main(String args[]) {
         int[][] matrix = new int[][] {{1,5,9},{4,5,6},{7,8,9}};
//        int[][] matrix = new int[][] {{1,5,9},{10,11,13},{12,13,15}};
//        int[][] matrix = new int[][] {{4,1,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] matrix = new int[][] {{4,1,11,15},{2,5,8,12,19}};
        int k = 8;
        // int kthSmalestElement = findKthSmallestElement(matrix, k);
        int kthSmallestElement = kthSmallest(matrix, k);
        System.out.println(kthSmallestElement);
    }

    public static int findKthSmallestElement(int[][] matrix, int k) {
        // Sort 2D matrix and find
        int n = matrix.length;
        int m = matrix[0].length;
        int kthminVal = Integer.MAX_VALUE;


        int swapRow = 0;
        int swapColumn = 0;

        int minRow = swapRow;
        int minColumn = swapColumn;

        while(swapRow < n && swapColumn < m) {
            System.out.println(matrix[swapRow][swapColumn]);

            int currentRow;
            int currentColumn;

            if (swapColumn == m - 1) {
                currentRow = swapRow + 1;
                currentColumn = 0;
            } else {
                currentColumn = swapColumn + 1;
                currentRow = swapRow;
            }

            while (currentRow < n && currentColumn < m) {
                if (matrix[currentRow][currentColumn] < matrix[minRow][minColumn]) {
                    minRow = currentRow;
                    minColumn = currentColumn;
                }

                System.out.println("MinRow" + minRow);
                System.out.println("MinColumn" + minColumn);
                System.out.println("MinValue" + matrix[minRow][minColumn]);

                if (currentColumn == m - 1) {
                    currentRow = currentRow + 1;
                    currentColumn = 0;
                } else {
                    currentColumn++;
                }
            }

            // Swap minRow and minColum value with swapColum and swapRow
            int temp = matrix[minRow][minColumn];
            matrix[minRow][minColumn] = matrix[swapRow][swapColumn];
            matrix[swapRow][swapColumn] = temp;

            k--;
            if (k == 0) {
                System.out.println("Result" + matrix[swapRow][swapColumn]);
                kthminVal =  matrix[swapRow][swapColumn];
                break;
            }

            if (swapColumn == m - 1) {
                swapRow = swapRow + 1;
                swapColumn = 0;
            } else {
                swapColumn++;
            }

            minRow = swapRow;
            minColumn = swapColumn;
        }
        return kthminVal;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<MyHeapNode>(Math.min(N, k), new MyHeapComparator());

        // Preparing our mean-heap
        for (int r = 0; r < Math.min(N, k); r++) {
            minHeap.offer(new MyHeapNode(matrix[r][0], r, 0));
        }

        MyHeapNode element = minHeap.peek();

        while(k-- > 0) {
            element =  minHeap.poll();
            int r = element.getRow();
            int c = element.getColumn();

            if (c < N - 1) {
                minHeap.offer(new MyHeapNode(matrix[r][c+1], r, c + 1));
            }
        }

        return element.getValue();
    }
}


