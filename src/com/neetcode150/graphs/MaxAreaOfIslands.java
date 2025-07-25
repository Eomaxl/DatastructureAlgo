package com.neetcode150.graphs;

import java.util.*;

public class MaxAreaOfIslands {

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i =0; i < rows; i++) {
            for (int j =0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea,bfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int row, int col) {
        grid[row][col] = 0;
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int[] dir: direction) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    q.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0;
                    count++;
                }
            }
        }
        return count;
    }
}
