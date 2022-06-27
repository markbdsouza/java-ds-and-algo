package com.markbdsouza.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * URL: https://leetcode.com/problems/set-matrix-zeroes/
 * Level: MEDIUM
 * Tags: Array, Hashtable, Matrix
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 */
public class Problem073SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        // keep 2 sets to store which rows and columns to set to zero
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        // reiterate and check if the row or column needs to be set to 0 and set it
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
