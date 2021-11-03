package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuCheckerProblem {
    public static void main(String args[]) {
        List<List<Integer>> sudokuBoard = new ArrayList<List<Integer>>();
        sudokuBoard.add(Arrays.asList(5,3,0,0,7,0,0,0,0));
        sudokuBoard.add(Arrays.asList(6,0,0,1,9,5,0,0,0));
        sudokuBoard.add(Arrays.asList(0,9,8,0,0,0,0,6,0));
        sudokuBoard.add(Arrays.asList(8,0,0,0,6,0,0,0,3));
        sudokuBoard.add(Arrays.asList(4,0,0,8,0,3,0,0,1));
        sudokuBoard.add(Arrays.asList(7,0,0,0,2,0,0,0,6));
        sudokuBoard.add(Arrays.asList(0,6,0,0,0,0,2,8,0));
        sudokuBoard.add(Arrays.asList(0,0,0,4,1,9,0,0,5));
        sudokuBoard.add(Arrays.asList(0,0,0,0,8,0,0,7,9));

        System.out.println(sudokuBoard);

        //boolean isValidSudoku = isValidSudoku(sudokuBoard);

    }

    public static boolean isValidSudoku(ArrayList<ArrayList<Integer>> board) {


        return false;
    }

}
