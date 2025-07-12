package com.graphs.shortestPathAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a weighted, undirected graph of V vertices, numbered from 0 to V-1, and an adjacency list adj where adj[i] is a list of lists
 * containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that edge .
 *
 * Given a source node S. Find the shortest distance of all the vertex from the source vertex S.
 * Return a list of integers denoting shortest distance between each node and source vertex S.
 * If a vertex is not reachable from source then its distance will be 109.
 *
 * */
public class DijkstraAlgo {

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){


            // Priority queue
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    Comparator.comparingInt(a -> a[0])
            );

            // Distance array
            int[] dist = new int[V];
            Arrays.fill(dist, (int) 1e9);

            // Distance of source node from itself is 0
            dist[S] = 0;

            // Add the source node to the priority queue
            pq.add(new int[]{0, S});

            // Until the priority queue is empty
            while (!pq.isEmpty()) {

                // Get the tentative distance
                int dis = pq.peek()[0];

                // Get the node
                int node = pq.peek()[1];
                pq.poll();

                // Traverse all its neighbors
                for (ArrayList<Integer> it : adj.get(node)) {

                    int adjNode = it.get(0); // node
                    int edgeWt = it.get(1); // edge weight

                /* If the tentative distance to
                reach adjacent node is smaller
                than the known distance */
                    if (dis + edgeWt < dist[adjNode]) {

                        // Update the known distance
                        dist[adjNode] = dis + edgeWt;

                        // Push the new pair in priority queue
                        pq.add(new int[]{dist[adjNode], adjNode});
                    }
                }
            }

            // Return the result
            return dist;
    }

    public static void main(String[] args) {
        int V = 2, S = 0;

        // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> node0 = new ArrayList<>();
        node0.add(new ArrayList<>(Arrays.asList(1, 9)));
        adj.add(node0);

        ArrayList<ArrayList<Integer>> node1 = new ArrayList<>();
        node1.add(new ArrayList<>(Arrays.asList(0, 9)));
        adj.add(node1);


        /* Function call to find the shortest distance
        of each node from the source node */
        int[] ans = dijkstra(V, adj, S);

        // Output
        System.out.print("The shortest distance of nodes from the source node is: ");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

    }
}
