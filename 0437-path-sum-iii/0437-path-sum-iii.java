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
    public int pathSum(TreeNode root, int targetSum) {
         Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return helper(root, (long) targetSum, 0, map);
    }

    private int helper(TreeNode node, long targetSum, long preSum, Map<Long, Integer> map) {
        if (node == null) {
            return 0;
        }
        preSum += node.val;
        int res = map.getOrDefault(preSum - targetSum, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        res += helper(node.left, targetSum, preSum, map) + helper(node.right, targetSum, preSum, map);
        map.put(preSum, map.get(preSum) - 1);
        return res;
    //     if(root==null) return 0;
    //     int n = dfs(root, targetSum), left = pathSum(root.left, targetSum), right = pathSum(root.right, targetSum);
    //     return n+left+right;
    // }
    // public int dfs(TreeNode node, int targetSum){
    //         if(node==null) return 0;
    //         int sum=0;
    //         if(targetSum==node.val) sum++;
    //         sum+= dfs(node.left, targetSum-node.val);
    //         sum+= dfs(node.right, targetSum-node.val);
    //         return sum;
        
    }
}