package leetcode.graphs;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    void printBFS(Node node){
        Node start = node;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        Node temp = queue.poll();
        while (temp != null){
            System.out.println(temp.val + " ");
            for(Node inner: temp.neighbors){
                if(!visited.contains(inner)){
                    queue.add(inner);
                    visited.add(inner);
                }
            }
            temp = queue.poll();
        }
    }
    void printDFS(Node node, Set<Node> set){
        if(!set.contains(node)){
            System.out.println(node.val);
            set.add(node);
            for(Node n: node.neighbors){
                printDFS(n, set);
            }
        }
        else{
            return;
        }


    }

    public static void main(String[] args) {
        Set<Node> set = new HashSet<>();
    }

}
