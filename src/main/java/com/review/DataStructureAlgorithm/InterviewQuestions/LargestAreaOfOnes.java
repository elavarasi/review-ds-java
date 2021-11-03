package com.review.DataStructureAlgorithm.InterviewQuestions;

/**
 * Find Largest area of Square 1s
 *
 */
public class LargestAreaOfOnes {
    public static void main(String args[]) {
        int[][] inputMatrix = new int[][]
                {
                {1,1,1,0},
                {1,0,1,1},
                {1,0,1,0},
                {1,1,1,0}
            };
        System.out.println(findLargestOneArea(inputMatrix));
    }

    private static int findLargestOneArea(int[][] inputMatrix) {
        int[] maxArea = new int[1];
        maxArea[0] = 0;
        int[][] adjacentMatrix = new int[][]
                {
                        {-1,-1,-1,-1},
                        {-1,-1,-1,-1},
                        {-1,-1,-1,-1},
                        {-1,-1,-1,-1}
                };

        for(int i=0; i<inputMatrix.length; i++) {
            for(int j=0; j<inputMatrix.length; j++) {
                if (inputMatrix[i][j] == -1) {
                    findLargestAreaOfEachPosition(i, j, inputMatrix, adjacentMatrix, maxArea);
                }

            }
        }

        findLargestAreaOfEachPosition(0, 0, inputMatrix, adjacentMatrix, maxArea);
        return maxArea[0];
    }

    private static int findLargestAreaOfEachPosition(int row, int col, int[][] inputMatrix, int[][] adjacentMatrix, int[] maxArea) {
        if (row >= inputMatrix.length || col >= inputMatrix.length) {
            return 0;
        }

        if (adjacentMatrix[row][col] != -1) {
            return adjacentMatrix[row][col];
        } else {

            if (inputMatrix[row][col] == 0) {
                adjacentMatrix[row][col] = inputMatrix[row][col];
                return 0;
            }

            adjacentMatrix[row][col] = inputMatrix[row][col];
            int areaOfRightAdjacentArea = findLargestAreaOfEachPosition(row, col + 1, inputMatrix, adjacentMatrix, maxArea);
            int areaOfDiagonalAdjacentArea = findLargestAreaOfEachPosition(row + 1, col + 1, inputMatrix, adjacentMatrix, maxArea);
            int areaOfBottomAdjacentArea = findLargestAreaOfEachPosition(row + 1, col, inputMatrix, adjacentMatrix, maxArea);

            int largestArea = Math.min(Math.min(areaOfRightAdjacentArea, areaOfDiagonalAdjacentArea), areaOfBottomAdjacentArea) + 1;

            adjacentMatrix[row][col] = largestArea;

            maxArea[0] = Math.max(maxArea[0], largestArea);
            return largestArea;
        }
    }
}
