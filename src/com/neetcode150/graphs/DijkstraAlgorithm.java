package com.neetcode150.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public int[] dijkstra(int V, List<List<List<Integer>>> adj, int S){
        // create a distance array
        int[] distance = new int[V];
        Arrays.fill(distance, 100_00_00_000);

        // priorityQueue
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Distance set to zero for source
        distance[S]= 0;

        queue.add(new int[]{0, S});

        while (!queue.isEmpty()){
            int dist = queue.peek()[0];
            int node = queue.peek()[1];

            queue.poll();

            for(List<Integer> it: adj.get(node)){
                int adjNode = it.get(0);
                int wt = it.get(1);

                if (dist + wt < distance[adjNode]){
                    distance[adjNode] = dist + wt;
                    queue.add(new int[]{distance[adjNode], adjNode});
                }
            }
        }
        return distance;
    }
}
