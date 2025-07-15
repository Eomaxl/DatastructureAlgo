package com.graphs.shortestPathAlgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an n x m matrix grid where each cell contains either 0 or 1, determine the shortest distance between a source cell and a destination cell.
 * You can move to an adjacent cell (up, down, left, or right) if that adjacent cell has a value of 1. The path can only be created out of cells containing 1.
 * If the destination cell is not reachable from the source cell, return -1.
 *
 * Input: grid = [[1, 1, 1, 1],[1, 1, 0, 1],[1, 1, 1, 1],[1, 1, 0, 0],[1, 0, 0, 1]], source = [0, 1], destination = [2, 2]
 * Output: 3
 * Explanation: The shortest path from (0, 1) to (2, 2) is:
 * Move down to (1, 1)
 * Move down to (2, 1)
 * Move right to (2, 2)
 * Thus, the shortest distance is 3
 *
 * */

public class ShortestDistanceInBinaryMaze {
    private static int[][] direction = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

    public static void main(String[] args){
        int[][] grid = {{1,1,1,1}, {1,1,0,1}, {1,1,1,1}, {1,1,0,0}, {1, 0, 0, 1}};
        int[] source = {0,1};
        int[] destination  = {2,2};
        ShortestDistanceInBinaryMaze s = new ShortestDistanceInBinaryMaze();
        System.out.println("The shortest distance : "+s.shortestPath(grid, source, destination));
    }
    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.offer(new int[]{source[0], source[1], 0});
        visited[source[0]][source[1]] = true;



        while(!queue.isEmpty()){

            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if(row == destination[0] && col == destination[1]){
                return dist;
            }

            for(int[] neighbor : direction){
                int newRow = row + neighbor[0];
                int newCol = col + neighbor[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol, dist + 1});
                }
            }
        }
        return -1;
    }
}
