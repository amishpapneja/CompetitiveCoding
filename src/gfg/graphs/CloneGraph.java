package gfg.graphs;

import java.util.*;

public class CloneGraph {
    public static GraphNode copyNode(GraphNode node, Map<Integer,GraphNode> visited){
        if(node == null) return null;
        if(visited.containsKey(node.val)) return visited.get(node.val);
        else{
            GraphNode newNode = new GraphNode(node.val);
            visited.put(newNode.val, newNode);
            for(GraphNode inner: node.neighbors){
                newNode.neighbors.add(copyNode(inner, visited));
            }
            return newNode;
        }
    }

    public static void main(String[] args) {
        //[[2,4],[1,3],[2,4],[1,3]]
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4, node5);
        node4.neighbors = Arrays.asList(node1, node3);
        node5.neighbors = Arrays.asList(node3);
        node1.printBFS(node1);
        System.out.println("--");
        node1.printDFS(node1, new HashSet<GraphNode>());

        GraphNode clone = copyNode(node1, new HashMap<Integer,GraphNode>());
        System.out.println("--");
        Set<GraphNode> set = new HashSet<>();
//        set.add(clone);
        clone.printDFS(clone,set);


//        node.val = 1;
//        node.neighbors(Arrays.asList({}))
    }
}
