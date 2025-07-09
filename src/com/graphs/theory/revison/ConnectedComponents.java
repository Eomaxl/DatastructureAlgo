package com.graphs.theory.revison;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. The ith edge is represented by [ai,bi],
 * denoting a edge between vertex ai and bi. We say two vertices u and v belong to a same component if there is a path from u to v or v to u.
 * Find the number of connected components in the graph.
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices,
 * and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
 * Input: V=4, edges=[[0,1],[1,2]]
 * Output: 2
 *
 * Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.
 *
 * Input: V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]
 * Output: 3
 *
 * Explanation:
 * The edges [0, 1], [1, 2], [2, 3] form a connected component with vertices {0, 1, 2, 3}.
 * The edge [4, 5] forms another connected component with vertices {4, 5}.
 * Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the isolated vertices {6} (vertices 6 and any other unconnected vertices).
 * */
public class ConnectedComponents {
    public static void main(String[] args){
        int V = 7;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(0,1));
        edges.add(List.of(1,2));
        edges.add(List.of(2,3));
        edges.add(List.of(4,5));
        System.out.println("Total connected numbers using DFS are : "+findNumberOfComponents(V, edges));
        System.out.println("Total connected numbers using BFS are : "+findNumberOfComponents(V, edges));
    }

    public static int findNumberOfComponents(int V, List<List<Integer>> edges){
        int result = 0;
        boolean[] visited = new boolean[V];

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }

        // build adjacency list
        for(List<Integer> edge: edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        for(int i =0; i <V; i++){
            if(!visited[i]) {
                dfs(i, visited, adjList);
                result++;
            }
        }

       return result;
    }

    public static void dfs(int idx, boolean[] visited, List<List<Integer>> adjList){
        visited[idx] = true;
        for(int neighbor : adjList.get(idx)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, adjList);
            }
        }
    }

    public static void bfs(int idx, boolean[] visited, List<List<Integer>> adjList){
        visited[idx] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int neighbor : adjList.get(cur)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);

                }
            }
        }
    }
}
