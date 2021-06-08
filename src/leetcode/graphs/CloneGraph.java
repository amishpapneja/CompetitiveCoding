package leetcode.graphs;

import java.util.*;

public class CloneGraph {
    public static Node copyNode(Node node, Map<Integer, Node> visited){
        if(node == null) return null;
        if(visited.containsKey(node.val)) return visited.get(node.val);
        else{
            Node newNode = new Node(node.val);
            visited.put(newNode.val, newNode);
            for(Node inner: node.neighbors){
                newNode.neighbors.add(copyNode(inner, visited));
            }
            return newNode;
        }
    }

    public static void main(String[] args) {
        //[[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4, node5);
        node4.neighbors = Arrays.asList(node1, node3);
        node5.neighbors = Arrays.asList(node3);
        node1.printBFS(node1);
        System.out.println("--");
        node1.printDFS(node1, new HashSet<Node>());

        Node clone = copyNode(node1, new HashMap<Integer, Node>());
        System.out.println("--");
        Set<Node> set = new HashSet<>();
//        set.add(clone);
        clone.printDFS(clone,set);


//        node.val = 1;
//        node.neighbors(Arrays.asList({}))
    }
}
