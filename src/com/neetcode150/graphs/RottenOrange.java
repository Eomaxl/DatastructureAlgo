package com.neetcode150.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    public int RottenOrange(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(fresh > 0 && !queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i< len; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
