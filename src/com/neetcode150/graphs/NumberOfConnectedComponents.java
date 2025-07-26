package com.neetcode150.graphs;

import java.util.*;

public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i =0 ; i< n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] curr: edges){
            adjList.get(curr[0]).add(curr[1]);
            adjList.get(curr[1]).add(curr[0]);
        }
        int count = 0;


        for(int i =0 ; i<n; i++){
            if(!visited[i]){
                count = count + 1;
                dfs(adjList, visited, i);

            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int node){
        visited[node] = true;

        for(int nei: adj.get(node)){
            if(!visited[nei]){
                dfs(adj, visited, nei);
            }
        }
    }
}
