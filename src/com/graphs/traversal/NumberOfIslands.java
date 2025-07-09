package com.graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a grid of size N x M (N is the number of rows and M is the number of columns in the grid) consisting of '0's (Water) and ‘1's(Land). Find the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 *
 *Input: grid = [ ["1", "1", "1", "0", "1"], ["1", "0", "0", "0", "0"], ["1", "1", "1", "0", "1"], ["0", "0", "0", "1", "1"] ]
 * Output: 2
 *
 * Explanation: This grid contains 2 islands. Each '1' represents a piece of land, and the islands are formed by connecting adjacent lands horizontally or vertically.
 * Despite some islands having a common edge, they are considered separate islands because there is no land connectivity in any of the eight directions between them.
 * Therefore, the grid contains 2 islands.
 * */
public class NumberOfIslands {
    private static final int[][] direction = new int[][]{{-1, -1}, {-1,0}, {-1,1}, {0,-1},{0,1},{1,-1},{1,0},{1,1} };

    public static void main(String[] args){
        char [][] grid  = {{'1', '1', '1', '0', '1'},{'1','0','0','0','0'},{'1','1','1','0','1'},{'0','0','0','1','1'}};
        System.out.println("The number of islands are : "+findNumOfIsland(grid));
    }

    public static int findNumOfIsland(char[][] grid){
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i =0; i< row; i++){
            for(int j =0; j< col; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        grid[i][j] = '0';

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int[] dir: direction) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1'){
                    queue.add(new int[]{newRow,newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
}
