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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0) return list;
        if (N == 1) { 
            list.add(new TreeNode(0));
            return list;
        }
        for (int leftNum = 1; leftNum <= N-1; leftNum += 2) {
            List<TreeNode> fLeft = allPossibleFBT(leftNum);
            List<TreeNode> fRight = allPossibleFBT(N-leftNum-1);
            for (TreeNode left: fLeft) {
                for (TreeNode right: fRight) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}