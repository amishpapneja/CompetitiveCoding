package assessment.bloomberg;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/***

 2.
    i
   / \
  r   y
 / \
 p  v

 0 - i
 -1 -r

 i -0, r- -1, p - -2, v - 0, y - +1

 privy
 // map (data, positioi
 // map (position, list(data)) -> duplicates.
 // way to determine the (how left is ist)
 result: privy


 3.
 a
 /
 i
 /
 c

 result: cia


 left > top> bottom> right
 //
 ***/



public class Solution {
    public static TreeMap<Integer, List<Character>> map;

    static Node createTree3() {
        Node root = new Node('a',null,null);
        Node n2 = new Node('i', null ,null);
        Node n3 = new Node('c',null, null);
        root.setLeft(n2);
        n2.setLeft(n3);
        return root;
    }

    static Node createTree2() {
        Node root = new Node('i',null,null);
        Node r = new Node('r', null,null);
        Node p = new Node('p',null,null);
        Node v = new Node('v',null,null);
        Node y = new Node('y',null,null);

        root.setLeft(r);
        root.setRight(y);
        r.setLeft(p);
        r.setRight(v);

        return root;

    }

    public static void main(String[] args) {
        // go till the left most leaf. [ only left]
        // move to the parent
        // left ->
        map =new TreeMap<>();
        Node root = createTree3();
        Node root2 = createTree2();
        // printInOrder(root);
        // System.out.println();
        printInOrder(root2, 0);
        // data strucuture ->  contains key - > list
        // Worst case -> no of states * max(list)
        // O(m*k) _> Practical -> O(n)
        for(Map.Entry<Integer, List<Character>> entry: map.entrySet()){
            for(Character ch: entry.getValue()){
                System.out.print(ch +" ");
            }
        }


        // root ,0 -> root.left, -1. root.right, +1
    }
    public static void printInOrder(Node node, int state ){
        // preserve the level and check while putting into the map
        // list -> the levels along with the data -> sort them via the levels.

        if(node == null){
            return;
        }
        System.out.println(node.getData() + "State is " + state); // store it in the map

        if(!map.containsKey(state)){
            List<Character> list = new ArrayList<>();
            list.add(node.getData());
            map.put(state,list);
        }
        else{
            map.get(state).add(node.getData());
        }
        printInOrder(node.getLeft(), state -1); // one left (pass , one less than the current state)


        printInOrder(node.getRight(), state + 1); // one right level of current node
    }
}
class Node {
    private char data;
    private Node left;
    private Node right;
    public Node(char data, Node l, Node r)
    {
        this.data = data;
        this.left = l ;
        this.right = r;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right){
        this.right = right;
    }

    boolean hasLeft() {
        return this.left != null ? true : false;
    }

    boolean hasRight() {
        return this.right != null ? true : false;
    }

    Node getLeft() {
        return this.left;
    }

    Node getRight() {
        return this.right;
    }
    char getData() {
        return this.data;
    }
}

