package com.neetcode150.binarysearch;

/**
 * You are given an m x n 2-D integer array matrix and an integer target.
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 * Can you write a solution that runs in O(log(m * n)) time?
 * Example : Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10 Output: true
 * Example : Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15 Output: false
 * */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(matrix, 10));
        System.out.println(search2DMatrix.searchMatrix(matrix, 15));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int l = 0, r = ROWS * COLS -1;
        while ( l <= r) {
            int m  = l + ( r - l ) / 2;
            int row = m /COLS, col = m % COLS;
            if ( target > matrix[row][col]){
                l = m + 1;
            } else if ( target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
