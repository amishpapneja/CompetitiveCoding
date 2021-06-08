package gfg.graphs;

import java.util.*;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    void printBFS(GraphNode node){
        GraphNode start = node;
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        GraphNode temp = queue.poll();
        while (temp != null){
            System.out.println(temp.val + " ");
            for(GraphNode inner: temp.neighbors){
                if(!visited.contains(inner)){
                    queue.add(inner);
                    visited.add(inner);
                }
            }
            temp = queue.poll();
        }
    }
    void printDFS(GraphNode node, Set<GraphNode> set){
        if(!set.contains(node)){
            System.out.println(node.val);
            set.add(node);
            for(GraphNode n: node.neighbors){
                printDFS(n, set);
            }
        }
        else{
            return;
        }


    }

    public static void main(String[] args) {
        Set<GraphNode> set = new HashSet<>();
    }

}
