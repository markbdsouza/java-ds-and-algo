package com.markbdsouza.leetcode;

/**
 * URL: https://leetcode.com/problems/rotate-image/
 * Level: MEDIUM
 * Tags: Array, Math, Matrix
 * <p>
 * ou are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class Problem048RotateImage {
    public void rotate(int[][] matrix) {
        // to rotate clockwise, transpose (row to column) and reverse Row(first el becomes last in a row & vice versa)
        transpose(matrix);
        reverseRow(matrix);
    }

    /**
     *  Reverse the row such that 1st element is now last element in the same row and vice versa
     * @param matrix
     */
    private void reverseRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int startIndex = 0;
            int endIndex = matrix[i].length - 1;
            while (startIndex <= endIndex) {
                int tmp = matrix[i][startIndex];
                matrix[i][startIndex] = matrix[i][endIndex];
                matrix[i][endIndex] = tmp;
                startIndex++;
                endIndex--;
            }

        }
    }

    /**
     * Convert row to column and vice versa
     *
     * @param matrix
     */
    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Problem048RotateImage a = new Problem048RotateImage();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
        a.rotate(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("---------------------------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
