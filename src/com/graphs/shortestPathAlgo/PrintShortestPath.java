package com.graphs.shortestPathAlgo;

import java.util.*;

/**
 * Given a weighted undirected graph having n vertices numbered from 1 to n and m edges describing there are edges, where edges[i]=[ai,bi,wi],
 * representing an edge from vertex ai to bi with weight wi.
 * Find the shortest path between the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1.
 * If there exists a path, then return a list whose first element is the weight of the path and the remaining elements represent the shortest path from vertex 1 to vertex n.
 *
 * Input: n = 5, m= 6, edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
 * Output: 5 1 4 3 5
 *
 * Explanation: The source vertex is 1.
 * Hence, the shortest distance path of node 5 from the source will be 1->4->3->5 as this is the path with a minimum sum of edge weights from source to destination.
 *
 * */

public class PrintShortestPath {
    public List<Integer> shortestPath(int n , int m, int[][] edges) {
        // Adjacency list to store the graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i <=n;i++){
            adj.add(new ArrayList<>());
        }

        // Add the edges to the graph
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // Using the priority queue to implement Dijkstra
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Parent array
        int[] parent = new int[n + 1];

        // Mark each node as its own parent initially
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Distance of source node (node  1) to itself is zero
        dist[1] = 0;

        // Push the source node to the queue
        queue.add(new int[]{0, 1});


        // until the queue is empty
        while(!queue.isEmpty()){
            //Get the pair containing the node having minimum distance from source node
            int[] curr = queue.poll();

            int node = curr[1];
            int distance = curr[0];

            // iterate through the neighbours
            for(int[] neighbor : adj.get(node)){
                int adjNode = neighbor[0];
                int edgeWt = neighbor[1];

                // If the tentative distance to reach adjacent node is smaller than the known distance
                if (distance + edgeWt < dist[adjNode]) {

                    // update the known distance
                    dist[adjNode] = distance + edgeWt;

                    // push the new pair to the priority queue
                    queue.add(new int[]{distance + edgeWt, adjNode});

                    // Update the parent of the adjNode to the recent node (where it came from)
                    parent[adjNode] = node;
                }
            }
        }

        // If the distance to the node could not be found, return an array containing -1
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        // Array to store the path
        List<Integer> path = new ArrayList<>();

        // Start from the destination node
        int node = n;


        // Iterate backwards from destination to source through the parent array
        while(parent[node] != node){

            //Add the node to the path
            path.add(node);

            // Take a step back
            node = parent[node];
        }

        // Add the source node to the path
        path.add(1);


        // Since the path stored is in a reverse order, reverse the array to get the actual path
        Collections.reverse(path);

        // Add the path weight in the beginning
        path.add(0, dist[n]);

        // Return the result
        return path;
    }

    public static void main(String[] args){
        int n  =5, m =6;
        int[][] edges = {
                {1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}
        };
        PrintShortestPath sp = new PrintShortestPath();
        List<Integer> path = sp.shortestPath(n, m, edges);

        // Output
        System.out.println("The resulting path weight is : "+path.get(0));
        System.out.println("The path is: ");
        for (int i =1; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
        int a = 4, b = 4;
        int[][] edges1 = {{1,2,2},{2,3,4},{1,4,1},{4,3,3}};
        List<Integer> path1 = sp.shortestPath(a, b, edges1);
        System.out.println("The resulting path weight is : "+path1.get(0));
        System.out.println("The path is: ");
        for (int i =1; i<path1.size(); i++){
            System.out.print(path1.get(i)+" ");
        }
    }
}
