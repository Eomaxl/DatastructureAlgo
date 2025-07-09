package com.graphs.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected graph with V vertices.
 * Two vertices u and v belong to a single province if there is a path from u to v or v to u. Find the number of provinces.
 * The graph is given as an n x n matrix adj where adj[i][j] = 1 if the ith city and the jth city are directly connected, and adj[i][j] = 0 otherwise.
 *
 *
 * Input: adj=[ [1, 0, 0, 1], [0, 1, 1, 0], [0, 1, 1, 0], [1, 0, 0, 1] ]
 * Output: 2
 * Explanation:In this graph, there are two provinces: [1, 4] and [2, 3]. City 1 and city 4 have a path between them, and city 2 and city 3 also have a path between them.
 * There is no path between any city in province 1 and any city in province 2
 *
 *
 * * */
public class NumberOfProvinces {
    public static void main(String[] args){
        int[][] adj = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        System.out.println("Total number of provinces are : "+numProvinces(adj));
    }

    public static int numProvinces(int[][] adj) {
        // 1. Null check
        if (adj == null) return 0;
        if (adj.length == 0) return 0;

        int n = adj.length;
        // 2. Check if the matrix is square
        for (int i = 0; i < n; i++) {
            if (adj[i] == null || adj[i].length != n) {
                throw new IllegalArgumentException("Input adjacency matrix must be non-null, square, and size N x N.");
            }
        }

        boolean[] visited = new boolean[adj.length];
        int count = 0;

        for(int i =0; i< adj.length; i++){
            if(!visited[i]){
                count++;
                dfs(i,adj,visited);
            }
        }
        return count;
    }

    private static void dfs(int i, int[][] adj, boolean[] visited){
        visited[i] = true;

        for(int j = 0; j < adj.length;j++){
            if (adj[i][j] == 1 && !visited[j]  ){
                dfs(j,adj,visited);
            }
        }
    }
}
