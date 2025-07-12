package com.graphs.cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an undirected graph with V vertices labeled from 0 to V-1.
 * The graph is represented using an adjacency list where adj[i] lists all nodes connected to node i.
 * Determine if the graph contains any cycles.
 * Note: The graph does not contain any self-edges (edges where a vertex is connected to itself).
 *
 * */
public class DetectCycleUndirectedGraph {

    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        // Fill adjacency list
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        System.out.println("Does the undirected graph contain a cycle? : " + isCycle(V, adj));
    }

    public static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, List<Integer>[] adj) {
        visited[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If already visited and not the parent, cycle detected
                return true;
            }
        }
        return false;
    }
}
