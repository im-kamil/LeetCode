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
    public int widthOfBinaryTree(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root, 0);
        int max = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int end = 0, start =0;
            for(int i=0;i<size;i++){
                TreeNode rm = queue.remove();
                int idx = map.get(rm);
                if(i==0)
                    start = idx;
                if(i==size-1)
                    end = idx;
                
                if(rm.left!=null){
                    queue.add(rm.left);
                    map.put(rm.left, 2*idx+1);
                }
                
                if(rm.right!=null){
                    queue.add(rm.right);
                    map.put(rm.right, 2*idx+2);
                }
            }
            max=Math.max(max, end-start+1);
        }
        
        return max;
    }
}