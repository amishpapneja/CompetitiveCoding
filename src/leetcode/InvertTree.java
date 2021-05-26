package leetcode;

import gfg.binarytree.BinaryTree;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.left.right = new TreeNode(12);
        root.left.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);
//        root.inOrder();

    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.right != null && root.left != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        else if(root.right != null && root.left == null){
            root.left = root.right;
            root.right = null;
        }
        else if(root.left != null && root.right == null){
            root.right = root.left;
            root.left = null;
        }
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
