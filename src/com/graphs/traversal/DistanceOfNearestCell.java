package com.graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary grid of N x M. Find the distance of the nearest 1 in the grid for each cell.
 * The distance is calculated as |i1 - i2| + |j1 - j2|, where i1, j1 are the row number and column
 * number of the current cell, and i2, j2 are the row number and column number of the nearest
 * cell having value 1.
 *
 * Input: grid = [ [0, 1, 1, 0], [1, 1, 0, 0], [0, 0, 1, 1] ]
 * Output: [ [1, 0, 0, 1], [0, 0, 1, 1], [1, 1, 0, 0] ]
 *
 * Explanation: 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1)
 * are at a distance of 1 from 1's at (0,1),(0,2), (0,2), (2,3), (1,0) and (1,1) respectively.
 *
 *
 * Input: grid = [ [1, 0, 1], [1, 1, 0], [1, 0, 0] ]
 * Output: [ [0, 1, 0], [0, 0, 1], [0, 1, 2] ]
 *
 * Explanation: 0's at (0,1), (1,2), (2,1) and (2,2) are at a distance of 1, 1, 1 and 2
 * from 1's at (0,0),(0,2), (2,0) and (1,1) respectively.
 * */

public class DistanceOfNearestCell {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,1},{1,1,0},{1,0,0}};
        int[][] result = nearest(grid);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static  int[][] nearest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i =0; i<rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for(int[] dir: direction){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols ){
                    if(distance[newRow][newCol] > distance[row][col] + 1){
                        distance[newRow][newCol] = distance[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return distance;

    }
}
