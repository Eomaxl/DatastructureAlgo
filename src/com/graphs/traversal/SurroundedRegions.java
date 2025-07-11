package com.graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix mat of size N x M where every element is either ‘O’ or ‘X’.
 * Replace all ‘O’ with ‘X’ that is surrounded by ‘X’. An ‘O’ (or a set of ‘O’) is considered to be
 * surrounded by ‘X’ if there are ‘X’ at locations just below, above, left, and right of it
 *
 * Input: mat = [ ["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"] ]
 * Output: [ ["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "O", "X", "X"] ]
 *
 * Input: mat = [ ["X", "X", "X"], ["X", "O", "X"], ["X", "X", "X"] ]
 * Output: [ ["X", "X", "X"], ["X", "X", "X"], ["X", "X", "X"] ]
 * */

public class SurroundedRegions {

    public static void main(String[] args){
        char[][] grid = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] result = fill(grid);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] fill (char[][] mat){
        if(mat == null  || mat.length == 0 || mat[0].length == 0){
            return mat;
        }

        int row = mat.length;
        int col = mat[0].length;


        for(int i =0; i< row; i++){
            for(int j =0; j< col; j++){
                if(mat[i][j] == 'O' && (i == 0 || j == 0 || i == row - 1 || j == col - 1){
                    bfs(mat, i, j, row, col);
                }
            }
        }

        for (int i =0; i<row; i++){
            for(int j =0; j<col; j++){
                if(mat[i][j] == 'O') mat[i][j] = 'X';
                if(mat[i][j] == '#') mat[i][j] = 'O';
            }
        }
        return mat;
    }

    private void bfs(char[][] mat, int row, int col, int rows, int cols){
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
        Queue <int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        mat[row][col] = '#';

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for(int[] direction : directions){
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];
                if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && mat[newRow][newCol] == 'O'){
                    mat[newRow][newCol] = '#';
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }
    }
}
