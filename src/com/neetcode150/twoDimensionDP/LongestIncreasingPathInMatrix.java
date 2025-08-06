package com.neetcode150.twoDimensionDP;

import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int ROW = matrix.length, COLS = matrix[0].length;
        int[][] indegree = new int[ROW][COLS];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COLS; j++) {
                for(int[] dir: directions) {
                    int nr = i + dir[0], nc = j + dir[1];
                    if(nr >=0 && nr < ROW && nc >=0 && nc < COLS && matrix[nr][nc] < matrix[i][j]) {
                        indegree[i][j]++;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COLS; c++) {
                if(indegree[r][c] == 0) q.add(new int[]{r, c});
            }
        }

        int LIS =0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for(int[] dir: directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if(nr >= 0 && nr < ROW && nc >=0 && nc < COLS && matrix[nr][nc] > matrix[r][c] ){
                        if(--indegree[nr][nc] == 0) q.offer(new int[]{r, c});
                    }
                }
            }
            LIS++;
        }
        return LIS;
    }
}
