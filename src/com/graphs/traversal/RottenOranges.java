package com.graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an n x m grid, where each cell has the following values :
 * 2 - represents a rotten orange
 * 1 - represents a Fresh orange
 * 0 - represents an Empty Cell
 * Every minute, if a fresh orange is adjacent to a rotten orange in 4-direction ( upward, downwards, right, and left ) it becomes rotten.
 * Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it's not possible, return -1
 *
 * Input: grid = [ [2, 1, 1] , [0, 1, 1] , [1, 0, 1] ]
 * Output: -1
 * Explanation: Orange at (3,0) cannot be rotten.
 *
 * Input: grid = [ [2,1,1] , [1,1,0] , [0,1,1] ]
 * Output: 4
 *
 * */

public class RottenOranges {
    private static int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid2 = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("Time taken to convert the whole box into rotten oranges :"+rottenOranges(grid1));
        System.out.println("Time taken to convert the whole box into rotten oranges :"+rottenOranges(grid2));
    }
    public static int rottenOranges(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // run through the rows and find the rotten orange and add it to the queue
        for(int i =0; i<rows; i++){
            if(grid[i][0] == 2){
                queue.offer(new int[]{i,0});
            }
        }

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            boolean flag = false;
            //check for direction
            for(int[] direction : directions){
                int newRow = curr[0] + direction[0];
                int newCol = curr[1] + direction[1];

                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;
                    flag = true;
                    queue.offer(new int[]{newRow,newCol});
                }
            }
            if(flag){
                result++;
            }
        }

        for(int i =0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return result;
    }
}
