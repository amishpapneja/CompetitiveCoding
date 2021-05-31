package leetcode;

public class IsSubtree {
    public static void main(String[] args) {

    }

    /**
     * ACCEPTED
     * Runtime: 3 ms, faster than 97.06% of Java online submissions for Subtree of Another Tree.
     * Memory Usage: 39.6 MB, less than 14.16% of Java online submissions for Subtree of Another Tree.
     *
     * **/

     public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if (isSame(root,subRoot))
                return true;
         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
     }



    public static boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if( (p!=null && q==null) || (p==null && q!= null) ) return false;
        else if(p.val != q.val) return false;
        else if(p.val == q.val) {
            return isSame(p.right,q.right) && isSame(p.left, q.left);
        }
        return true;
    }
}
