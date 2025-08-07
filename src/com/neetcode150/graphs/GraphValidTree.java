package com.neetcode150.graphs;

import java.util.*;

public class GraphValidTree {

        public boolean validTree(int n, int[][] edges) {
            if (edges.length > n - 1) {
                return false;
            }

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }


            Set<Integer> visit = new HashSet<>();
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, -1});  // {current node, parent node}
            visit.add(0);

            while (!q.isEmpty()) {
                int[] pair = q.poll();
                int node = pair[0], parent = pair[1];
                for (int nei : adj.get(node)) {
                    if (nei == parent) {
                        continue;
                    }
                    if (visit.contains(nei)) {
                        return false;
                    }
                    visit.add(nei);
                    q.offer(new int[]{nei, node});
                }
            }

            return visit.size() == n;

    }
}
