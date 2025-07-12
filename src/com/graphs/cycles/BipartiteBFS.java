package com.graphs.cycles;

import java.util.*;

public class BipartiteBFS {

    public boolean isBipartiteBFS(int V, List<List<Integer>> adj){
        /* To store the color of the nodes, where each node is uncolored initially */
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Traverse all the nodes
        for (int i = 0; i < V ; i++){
            // if not colored, start the traversal
            if(color[i] == -1){
                // return  false if graph is not bipartite
                if(!bfs(i, V, color, adj)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(int i, int V, int[] color, List<List<Integer>> adj){
        color[i] = 0;       // Mark with a color

        // Create a queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        // Add the initial node to the queue
        queue.add(i);

        // While the queue is not empty
        while(!queue.isEmpty()){
            // Get the node
            int cur = queue.poll();
            // Traverse all its neighbor
            for(int neighbor : adj.get(cur)){

                // If not already occupied
                if(color[neighbor] == -1){
                    // color it with opposite color
                    color[neighbor] = 1  - color[cur];
                    // Push the node in queue
                    queue.add(neighbor);
                }
                // Else if the neighbor has same color as node
                else if (color[neighbor] == color[cur]){
                    // Return false , as the component is not bipartite
                    return false;
                }
            }
        }

        // Return true if the component is bipartite
        return true;
    }
}
