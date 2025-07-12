package com.graphs.cycles;

/**
 * Topological sort or Kahn's algorithm
 * Given a Directed Acyclic Graph (DAG) with V vertices labeled from 0 to V-1.
 * The graph is represented using an adjacency list where adj[i] lists all nodes connected to node.
 * Find any Topological Sorting of that Graph.
 * In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
 * The Output will be True if your topological sort is correct otherwise it will be False.
 *
 * Input: V = 6,adj=[ [ ], [ ], [3], [1], [0,1], [0,2] ]
 * Output: [5, 4, 2, 3, 1, 0]
 * Explanation: A graph may have multiple topological sortings.
 * The result is one of them. The necessary conditions
 * for the ordering are:
 * According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
 * According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
 * According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
 * According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
 * According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
 * According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.
 * The above result satisfies all the necessary conditions.
 * [4, 5, 2, 3, 1, 0] is also one such topological sorting
 * that satisfies all the conditions.
 * */

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args){
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(){{add(3);}});
        adj.add(new ArrayList<>(){{add(1);}});
        adj.add(new ArrayList<>(){{add(0);add(1);}});
        adj.add(new ArrayList<>(){{add(0);add(2);}});
        int[] result = topoSort(V, adj);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]+" | ");
        }
    }

    public static int[] topoSort(int V, List<List<Integer>> adj) {
        // To store the result
        int[] result = new int[V];


        // Stack to store the processed nodes in reverse order
        Stack<Integer> stack = new Stack<>();
        // visited array
        int[] visited = new int[V];

        // Traverse the graph
        for (int i = 0; i < V; i++) {
            // Start DFS traversal for unvisited node
            if(visited[i] == 0){
                dfs(i, adj, visited, stack);
            }
        }

        //  Until the stack is empty
        for (int i = 0; i <V; i++){
            result[i] = stack.pop();
        }
        return result;
    }

    public static void dfs(int v, List<List<Integer>> adj, int[] visited, Stack<Integer> stack){
        // Mark the node as visited
        visited[v] = 1;

        // Traverse all the neighbors
        for (int it: adj.get(v)) {
            // if not visited , recursively perform DFS
            if (visited[it] == 0){
                dfs(it, adj, visited, stack);
            }
        }

        // Add the current node to the stack once all the neighbor has been processed.
        stack.push(v);
    }
}
