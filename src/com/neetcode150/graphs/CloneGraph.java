package com.neetcode150.graphs;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        oldToNew.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for(Node neighbor : curr.neighbors) {
                if(!oldToNew.containsKey(neighbor)) {
                    oldToNew.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                oldToNew.get(curr).neighbors.add(oldToNew.get(neighbor));
            }
        }
        return oldToNew.get(node);
    }
}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node(){
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val){
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors){
        val = _val;
        neighbors = _neighbors;
    }
}
