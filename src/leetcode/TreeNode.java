package leetcode;

import com.sun.source.tree.Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void inOrder(TreeNode root ){
        if(root == null) return;
        System.out.println(root.val);
        inOrder(root.left);
        right.inOrder(root.right);

    }
}

