/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
//         // If both p and q are null, then they are the same tree
//     if (p == null && q == null) return true;
    
//     // If only one of p and q is null, then they are not the same tree
//     if (p == null || q == null) return false;
    
//     // If the values of p and q are different, then they are not the same tree
//     if (p.val != q.val) return false;
    
//     // Recursively check the left and right subtrees of p and q
//     // If both the left and right subtrees are the same, then p and q are the same tree
//     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        if(p==null||q==null) return (p==q);
        
        return (p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}