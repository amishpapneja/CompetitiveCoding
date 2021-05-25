package assessment.amazon;

import corejava.comparator.oop.A;

import java.util.ArrayList;

public class Component {
    public static void main(String[] args) {
        ComponentNode root = new ComponentNode(200);

        ComponentNode left = new ComponentNode(120);
        ComponentNode lone = new ComponentNode(110);
        ComponentNode ltwo = new ComponentNode(20);
        ComponentNode lthree = new ComponentNode(30);
        ComponentNode lfour=new ComponentNode(10);

        left.components.add(lone);
        left.components.add(ltwo);
        left.components.add(lthree);
        left.components.add(lfour);


        ComponentNode right = new ComponentNode(180);
        ComponentNode rone = new ComponentNode(150);
        ComponentNode rtwo = new ComponentNode(80);
        ComponentNode rthree=new ComponentNode(5);

        right.components.add(rone);
        right.components.add(rtwo);
        right.components.add(rthree);

        root.components.add(left);
        root.components.add(right);
        ComponentNode found = findMaxNode(root);

        System.out.println(found.value);



    }
    static int countNodes(ComponentNode x) {
        if(x.components.size() == 0) {
            return 1;
        }
        int sum = 0;
        for(ComponentNode y: x.components) {
            sum += countNodes(y);
        }
        return 1 + sum;
    }
    static int countValues(ComponentNode x) {
        if(x.components.size() == 0) {
            return x.value;
        }
        int sum = 0;
        for(ComponentNode y: x.components) {
            sum += countValues(y);
        }
        return x.value + sum;
    }

    static boolean isLeaf(ComponentNode node) {
        return (node.components.size() == 0);
    }
    static boolean isJustAboveLeaf(ComponentNode node) {
        if(isLeaf(node)) {
            return false;
        }
        for(ComponentNode y: node.components) {
            if(y.components.size() != 0) {
                return false;
            }
        }
        return true;
    }

    static double avgChangeRate(ComponentNode node) {
        double count = (1.0 + countNodes(node));
        double value = (node.value + countValues(node));

        return value/count;
    }

    /*
    Main function
    */
    public static ComponentNode findMaxNode(ComponentNode root) {
        // base case.
        if(isJustAboveLeaf(root)) {
            return root;
        }

        ComponentNode maxNode = root;
        double maxChangeRate = avgChangeRate(root);

        for(ComponentNode y: root.components) {
            if(!isLeaf(y)) {
                ComponentNode maxSubNode = findMaxNode(y);
                double subChangeRate = avgChangeRate(maxSubNode);
                if(subChangeRate > maxChangeRate) {
                    maxChangeRate = subChangeRate;
                    maxNode = maxSubNode;
                }
            }
        }

        return maxNode;
    }

}

class ComponentNode{
    public int value;
    public ArrayList<ComponentNode> components;
    public ComponentNode(){
        components = new ArrayList<ComponentNode>();
    }
    public ComponentNode(int linesChanges ){
        this.value = linesChanges;
        this.components = new ArrayList<ComponentNode>();
    }
}