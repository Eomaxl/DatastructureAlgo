package com.neetcode150.graphs;

import java.util.*;

public class PrintShortestPath {

    public List<Integer> shortestPath1(int n, int m, int[][] edges) {
        // Initialize the array and minimum distance value
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0; i <= n; i++) adj.add(new ArrayList<>());

        for(int[] edge: edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        // Dijkstra Algorithm
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        parent[1] = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        pq.offer(new int[]{0,1});

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int currDist = current[0];
            int currNode = current[1];

            if(currDist > dist[currNode]) continue;

            for (int[] neighbor : adj.get(currNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (dist[currNode] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[currNode] + weight;
                    parent[nextNode]  = currNode;
                    pq.offer(new int[] {dist[nextNode], nextNode});
                }
            }
        }

        if( dist[n] == Integer.MAX_VALUE) return Arrays.asList(-1);

        List<Integer> path = new LinkedList<>();
        for(int node = n; node != -1; node = parent[node]) path.add(0, node);

        path.add(0, dist[n]);
        return path;
    }
}
