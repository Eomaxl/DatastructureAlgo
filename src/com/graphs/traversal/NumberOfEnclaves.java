package com.graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an N x M binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or
 * walking off the boundary of the grid.
 * Find the number of land cells in the grid for which we cannot walk off the
 * boundary of the grid in any number of moves.
 *
 * Input: grid = [[0, 0, 0, 0], [1, 0, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]]
 * Output: 3
 *
 *
 * Input: grid = [[0, 0, 0, 1],[0, 0, 0, 1], [0, 1, 1, 0], [0, 0, 1, 0], [0, 0, 0, 0]]
 * Output:3
 * */
public class NumberOfEnclaves {
    private static int[][] directions ={{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println("The number of enclaves  : "+numberOfEnclaves(grid));
    }

    public static int numberOfEnclaves(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue  = new LinkedList<>();

        // Add all the boundary land cells to the queue
        for(int i=0; i< rows; i++){
            if(grid[i][0] == 1) queue.offer(new int[]{i,0});
            if(grid[i][cols-1] == 1) queue.offer(new int[]{i,cols-1});
        }
        for(int j=0; j< cols; j++){
            if(grid[0][j] == 1) queue.offer(new int[]{0,j});
            if(grid[rows-1][j] == 1) queue.offer(new int[]{rows-1,j});
        }

        // BFS to mark all connected land cells
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // mark the current cell as visited (0)
            grid[row][col] = 0;

            // check all 4 directions
            for(int[] dir: directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // if the position is valid and is a land cell, add to the queue
                if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == 1){
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }

        // Count remaining land cells
        int count = 0;
        for (int i =  0; i < rows; i++){
            for( int j =0; j< cols; j++){
                if(grid[i][j] == 1)count++;
            }
        }
        return count;
    }
}
