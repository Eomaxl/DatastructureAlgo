package com.graphs.traversal;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a boolean 2D matrix grid of size N x M.
 * Find the number of distinct islands where a group of connected 1s (horizontally or vertically)
 * forms an island.
 * Two islands are considered to be same if and only if one island is equal to another
 * (not rotated or reflected).
 *
 * Input: grid = [[1, 1, 0, 0, 0], [1, 1, 0, 0, 0], [0, 0, 0, 1, 1],[0, 0, 0, 1, 1]]
 * Output: 1
 * */
public class NumberOfDistinctIslands {

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println("Distinct number of islands is :"+countDistinctIslands(grid));
    }

    public static int countDistinctIslands(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> distinctIslands = new HashSet<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i =0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(grid[i][j] == 1){
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, i, j, i, j, directions, shape);
                    distinctIslands.add(shape.toString());
                }
            }
        }
        return distinctIslands.size();
    }

    private static void dfs(int[][] grid, int row, int col, int baseRow, int baseCol, int[][] directions, StringBuilder shape){
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;
        shape.append(row-baseRow).append(",").append(col-baseCol).append(";");
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(grid, newRow, newCol, baseRow, baseCol, directions, shape);
        }
    }
}
