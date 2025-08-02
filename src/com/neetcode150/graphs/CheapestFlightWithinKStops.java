package com.neetcode150.graphs;

import java.util.*;

public class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        dist[src][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{0, src, -1});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int cst = top[0], node = top[1], stops = top[2];
            if (node == dst) return cst;
            if (stops == k || dist[node][stops + 1] < cst) continue;
            for (int[] neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if (dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    minHeap.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }
        return -1;
    }

    public int cheapestFlight(int n, int[][] flights, int src, int dst, int k){

        // Store the graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        // Adding edges to the list
        for(int[] edge: flights){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // To store minimum distance
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        // Queue to store elements in the form of {stops,{node,distance}}
        Queue<int[]> q = new LinkedList<>();

        // Add the source to the queue
        q.offer(new int[]{0,src, 0});

        // until the queue is empty
        while (!q.isEmpty()){
            // get the element from the queue
            int[] top = q.poll();
            int stops = top[0], node = top[1], distance = top[2];

            // if the number of stops taken exceeds K, skip and move to the next element
            if (stops > k) continue;

            // traverse all the neighbors
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0], edgeWt = neighbor[1];

                // If the tentative distance to reach adjacent node is smaller than the known distance and number of stops doesnot exceed k
                if (distance + edgeWt < minDistance[adjNode] && stops <= k){

                    // update the known distance
                    minDistance[adjNode] = distance + edgeWt;

                    // Add the element to the queue
                    q.offer(new int[]{stops + 1, adjNode, distance + edgeWt});
                }
            }
        }

        // If the destination is unreachable , return -1
        if (minDistance[dst] == Integer.MAX_VALUE) return -1;

        // return the result
        return minDistance[dst];
    }
}
