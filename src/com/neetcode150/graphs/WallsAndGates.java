package com.neetcode150.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void islandsAndTreasure(int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i =0; i<rows; i++){
            for (int j =0; j<cols; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        if(queue.isEmpty()) return;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            for(int[] d: dir){
                int newRow = row + d[0];
                int newCol = col + d[1];

                if(newRow >=rows || newCol >= cols || newRow < 0 || newCol < 0 || grid[newRow][newCol] != Integer.MAX_VALUE){
                    continue;
                }
                queue.add(new int[]{newRow, newCol});
                grid[newRow][newCol] = grid[row][col] + 1;
            }
        }
    }
}
