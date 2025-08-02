package com.neetcode150.graphs;

import java.util.*;

/**
 *
 * */
public class DetectCycle {
    public boolean isCycle(int V, List<Integer>[] adj){
        // visited array
        boolean[] visited = new boolean[V];

        // variable to store if there is a cycle detected;
        var result = false;

        // start traversal from every unvisited node
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                // Start bfs traversal and update result
                result = bfs(i, adj, visited);

                // break if a cycle is detected
                if (result) break;
            }
        }
        return result;
    }

    private boolean bfs(int i , List<Integer> adj[], boolean[] visited) {
        // Queue to store {node, parent}
        Queue<int[]> q = new LinkedList<>();

        // Push initial node in queue with no one as parent
        q.add(new int[]{i, -1});

        // Mark the node is visited
        visited[i] = true;

        // Until the queue is empty
        while(!q.isEmpty()){
            // Get the node and its parent
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];

            // traverse all the neighbors
            for (int it : adj[node]){
                // if not visited
                if(!visited[i]){
                    // mark the node as visited
                    visited[it]  = true;

                    // push the new node in the queue with curr node as parent
                    q.add(new int[]{it, node});
                }
                /* Else if it is visited with some
                different parent a cycle is detected */
                else if (it != parent) return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1,3));
        adj[1].addAll(Arrays.asList(0,2,4));
        adj[2].addAll(Arrays.asList(1,5));
        adj[3].addAll(Arrays.asList(0,4));
        adj[4].addAll(Arrays.asList(1,3,5));
        adj[5].addAll(Arrays.asList(2,4));

        DetectCycle detectCycle = new DetectCycle();
        if( !detectCycle.isCycle(V, adj)) {
            System.out.println("No cycle");
        } else {
            System.out.println("Cycle is detected");
        }
    }
}
