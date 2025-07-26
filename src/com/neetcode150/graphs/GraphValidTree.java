package com.neetcode150.graphs;

import java.util.*;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        Set<Integer> nodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        nodes.add(0);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.println(curr);
            if(!nodes.contains(curr)) return false;
            if (adj.get(curr).size() == 0 && (curr+ 1 < n)){
                if(!nodes.contains(curr+1)){queue.add(curr+1);}

                continue;
            }
            for(int nei: adj.get(curr) ){
                if(nodes.contains(nei)){
                    return false;
                } else {
                    nodes.add(nei);
                    queue.offer(nei);
                }
            }
        }
        return true;

    }
}
