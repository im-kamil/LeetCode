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
    int result = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true);
        return result;
    }
    
    public int dfs(TreeNode node, boolean isLeft){
        if(node == null){
            return 0;
        }
        //try start here
        int l = dfs(node.left, false);
        int r = dfs(node.right, true);
        result = Math.max(result, l);
        result = Math.max(result, r);
        //return sum for parent
        return 1 + (isLeft ? l : r);
    }
}