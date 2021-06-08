package gfg.graphs;


// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BFS {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void bfs(int s) {
        //maintain visited array to make sure that we process each node only once
        boolean visited[] = new boolean[V];
        //queue for BFS order
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true; // first entry node , make it true
        queue.add(s); // enque first node
        //START BFS
        Integer temp = queue.poll(); //poll first item
        while (temp != null) {
            //print the dequeued node and enqueue all of its children
            System.out.print(temp + " ");
            for (Integer node : adj[temp]) {
                //Only enqueue if not visited. No going back to a printed node
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
            temp = queue.poll(); //dequeue the upcoming node
        }
    }

    // Driver method to
    public static void main(String args[]) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.bfs(2);
    }
}




