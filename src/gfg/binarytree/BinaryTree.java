package gfg.binarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree {
    static class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;

    static void inorder(Node temp){
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    public static void deleteNode(Node root, int val){

        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        int lastNodeValue = -1;

        while(temp != null){
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            if(queue.size() == 1){
                System.out.println("The last node is: " + queue.peek().key);
                lastNodeValue = queue.peek().key;
            }
            temp = queue.poll();

        }

        temp = root;

        Node prevParent = null;
        boolean flag = false;
        while(temp != null){
            if(temp.key == val){
                temp.key = lastNodeValue;
                flag = true;
            }
            if(temp.left != null){
                queue.add(temp.left);
                prevParent = temp;
            }
            if(temp.right != null){
                queue.add(temp.right);
                prevParent = temp;
            }
            if(queue.size() == 1){
                System.out.println("The last node is: " + queue.peek().key);

                lastNodeValue = queue.peek().key;
            }
            temp = queue.poll();

        }
        if(prevParent.right.key == lastNodeValue) prevParent.right = null;
        if(prevParent.left.key == lastNodeValue) prevParent.left = null;


    }
    public static void insertNode(Node root, int val){
        Node toInsert = new Node(val);
        if(root == null){
            root = toInsert;
            return;
        }
        Node temp = root;
        Queue<Node> order = new LinkedList<>();
        while(temp != null){
            if(temp.left == null) {
                temp.left = toInsert;
                break;
            }
            else order.add(temp.left);
            if(temp.right == null){
                temp.right = toInsert;
                break;
            }
            else order.add(temp.right);
            temp = order.poll();
        }

    }
    // Driver code

    public static void main(String args[])
    {
        root = new Node(10);
        root.left = new Node(11);
        root.left.right = new Node(12);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print(
                "Inorder traversal before insertion:");
        inorder(root);

        int key = 20;
//        insertNode(root, key);
//        System.out.print(
//                "\nInorder traversal after insertion:");
//        inorder(root);
        deleteNode(root,7);
        System.out.println();
        inorder(root);
    }

}