package com.markbdsouza.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem054SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> listOfNumbers = new ArrayList<>();
        int rowStart=0, colStart = 0;
        int rowEnd = matrix.length -1;
        int colEnd = matrix[0].length -1;

        while(true){
            goLeftOrRight(matrix,listOfNumbers, colStart, colEnd, rowStart, 1);
            rowStart++;
            if(rowStart>rowEnd || colStart>colEnd) return listOfNumbers;

            printMatrix(matrix);
            goDownOrUp(matrix,listOfNumbers, rowStart, rowEnd, colEnd, 1);
            colEnd--;
            if(rowStart>rowEnd || colStart>colEnd) return listOfNumbers;

            printMatrix(matrix);
            goLeftOrRight(matrix,listOfNumbers, colEnd, colStart, rowEnd, -1);
            rowEnd--;
            if(rowStart>rowEnd || colStart>colEnd) return listOfNumbers;

            printMatrix(matrix);
            goDownOrUp(matrix,listOfNumbers, rowEnd,rowStart, colStart, -1);
            colStart++;
            if(rowStart>rowEnd || colStart>colEnd) return listOfNumbers;
        }
    }

    void goDownOrUp(int[][] matrix, List<Integer> listOfNumbers, int startIndex, int endIndex, int columnIndex, int increment){
        for(int i=startIndex;( increment>0 && i <=endIndex)|| (increment<0 && i >=endIndex); i=i+increment){
            System.out.print(" "+matrix[i][columnIndex]);
            listOfNumbers.add(matrix[i][columnIndex]);
        }
    }
    void goLeftOrRight(int[][] matrix, List<Integer> listOfNumbers, int startIndex, int endIndex, int rowIndex, int increment){
        for(int i=startIndex;( increment>0 && i <=endIndex)|| (increment<0 && i >=endIndex); i=i+increment){
            System.out.print(" "+matrix[rowIndex][i]);
            listOfNumbers.add(matrix[rowIndex][i]);
        }
    }

    public static void main(String[] args) {
        Problem054SpiralMatrix a = new Problem054SpiralMatrix();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrix(matrix);
        a.spiralOrder(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("---------------------------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
