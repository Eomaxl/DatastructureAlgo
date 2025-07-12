package com.graphs.cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an undirected graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes connected to node.
 * Determine if the graph is bipartite or not.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 * Input: V=4, adj = [[1,3],[0,2],[1,3],[0,2]]
 * Output: True
 * Explanation: The given graph is bipartite since, we can partition the nodes into two sets: {0, 2} and {1, 3}.
 *
 * Input: V=4, adj = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: False
 * Explanation: The graph is not bipartite. If we attempt to partition the nodes into two sets,
 * we encounter an edge that connects two nodes within the same set, which violates the bipartite property.
 * */

public class BipartiteGraph {
    public static void main(String[] args){
        int V = 4;
        List<Integer>[] graph = new ArrayList[4];
        graph[0] = new ArrayList<>(List.of(1, 3));
        graph[1] = new ArrayList<>(List.of(0, 2));
        graph[2] = new ArrayList<>(List.of(1, 3));
        graph[3] = new ArrayList<>(List.of(0, 2));

        System.out.println("Is the graph bipartite ? "+isBipartite(V,graph));
    }

    public static boolean isBipartite(int V, List<Integer>[] adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i< V; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, color, adj)){
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean dfs(int current , int currentColor, int[] color, List<Integer>[] adj){
        color[current] = currentColor;
        for(int neighbor : adj[current]){
            if(color[neighbor] == -1){
                if(!dfs(neighbor, 1-currentColor, color, adj)){
                    return false;
                }
            } else if (color[neighbor] == currentColor){
                return false;
            }
        }
        return true;
    }
}
