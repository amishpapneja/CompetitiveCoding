package leetcode;

public class SameTree {
    public static void main(String[] args) {

    }

    /**
     * Accepted
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
     * Memory Usage: 36.5 MB, less than 34.49% of Java online submissions for Same Tree.
     *
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if(p == null && q!=null || q ==null && p!= null) return false;
        if(p.val != q.val ) return false;
        if(p.val == q.val ) {
            return (isSameTree(p.right, q.right) && isSameTree(p.left, q.left));
        }
        return false;
    }
}
