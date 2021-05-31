package leetcode;

public class KthSmallestInBST {
    public static void main(String[] args) {

    }
    public  int count;
    public int found;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
//        inOrder(root);
        return found;
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
     * Memory Usage: 38.4 MB, less than 96.21% of Java online submissions for Kth Smallest Element in a BST.
     *
     */
//    public  void inOrder(TreeNode root){
//        if(root == null) return;
//        inOrder(root.left);
//        if(count == 1){
//            found = root.val;
//            count--;
//            return;
//        }
//        else{
//            count--;
//        }
//        inOrder(root.right);
//    }
}}
