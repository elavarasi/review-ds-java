package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;

/** Geeks for Geeks **/
// Place eight Queen on a chess board, not violating the rules.

public class EightQueen {
    public static void main(String args[]) {
        int[][] board = new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        final int N = 5;

        solvePlacingQueen(board, 0, N);
        printBoard(board, N);
    }

    public static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solvePlacingQueen(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }

        for (int row = 0; row < N; row ++ ) {
            if (isSafePosition(row, col, board, N)) {
                board[row][col] = 1;

                if(solvePlacingQueen(board, col + 1, N) == true) {
                    return true;
                }

                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafePosition(int row, int col, int[][] board, int N) {
        // check same row on left side
        for (int i = 0; i < col; i++ ) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check diagonal left top
        for (int i = row, j = col;  i >=0 && j >= 0; i--, j-- ) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
}