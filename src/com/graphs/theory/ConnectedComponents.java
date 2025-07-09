package com.graphs.theory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
    public static void main(String[] args) {
        ConnectedComponents obj = new ConnectedComponents();

        //Test case 1
        int v1 = 4;
        int e1 = 2;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(0,1));
        edges.add(List.of(1,2));
        System.out.println("Test case 1 : "+obj.findNumberOfComponents(2,4,edges));


        // Test case 2
        int v2 = 7;
        int e2 = 4;
        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(List.of(0,1));
        edges2.add(List.of(1,2));
        edges2.add(List.of(2,3));
        edges2.add(List.of(4,5));
        System.out.println("Test case 2 : "+obj.findNumberOfComponents(e2,v2,edges2));
    }

    public int findNumberOfComponents(int E, int V, List<List<Integer>> edges) {
        //Create adjacent list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        //build the adjacent list
        for(List<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] visited = new boolean[V];
        int components = 0;

        for(int i=0; i <V; i++){
            if(!visited[i]){
                dfs(i, adj, visited);
                components++;
            }
        }
        return components;
    }

    private void dfs(int i, List<List<Integer>> adj, boolean[] visited){
        // mark the node as visited
        visited[i] = true;

        // Traverse its unvisited adjacents
        for(int neighbor : adj.get(i)){
            if(!visited[neighbor]){
                // Recursively perform dfs
                dfs(neighbor, adj, visited);
            }
        }

    }

    private void bfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;

        // Queue required for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        // To start traversal from node
        queue.add(node);

        // Keep traversing till the queue is not empty
        while (!queue.isEmpty()){
            // Get the node
            int i = queue.poll();

            // Traverse it's unvisited neighbours
            for(int adjNodes : adj.get(i)){
                if(!visited[adjNodes]){

                    // mark the node as visited
                    visited[adjNodes] = true;

                    // add the node to the queue
                    queue.add(adjNodes);
                }
            }
        }
    }
}
