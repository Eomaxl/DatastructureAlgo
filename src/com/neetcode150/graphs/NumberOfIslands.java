package com.neetcode150.graphs;

import java.util.*;

public class NumberOfIslands {
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i =0; i< rows; i++) {
            for(int j = 0; j< cols; j++){
                if (grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = 0;
        queue.add(new int[]{r,c});
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0], col = node[1];
            for(int[] dir: direction){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow >=0 && newRow <grid.length && newCol >= 0 && newCol < grid[0].length &&grid[newRow][newCol] == '1'){
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
}
