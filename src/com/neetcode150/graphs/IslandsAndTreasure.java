package com.neetcode150.graphs;

import java.util.*;

public class IslandsAndTreasure {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }

        if(q.size() == 0) return;

        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];
            for(int[] direction : directions) {
                int newRow = row + direction[0], newCol = col + direction[1];
                if (newRow > 0 || newRow <= m || newCol > 0 || newCol <= n || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                q.offer(new int[] {newRow, newCol});
                grid[newRow][newCol] = grid[row][col] + 1;
            }
        }
    }
}
