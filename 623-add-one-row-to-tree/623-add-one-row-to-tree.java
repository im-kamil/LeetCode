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
// class Solution {
//     public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
//     }
// }
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        insert(root,v,d,1);
        return root;
    }
    
    public void insert(TreeNode node, int val, int depth, int currentDepth) {
        if(node == null) return;
        if(depth-1 == currentDepth) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        }
        else {
            insert(node.left, val, depth, currentDepth+1);
            insert(node.right, val, depth, currentDepth+1);
        }
    }
}
// class Solution {
// 	public TreeNode addOneRow(TreeNode root, int v, int d) {
// 		if(d == 1){
// 			TreeNode node = new TreeNode(v);
// 			node.left = root;
// 			return node;
// 		}
// 		Queue<TreeNode> q = new LinkedList<>();
// 		q.add(root);
// 		int currentDepth = 1;
// 		while(currentDepth < d-1) {
// 			Queue<TreeNode> temp = new LinkedList<>();
// 			while(!q.isEmpty()){
// 				TreeNode node = q.remove();
// 				if(node.left != null) temp.add(node.left);
// 				if(node.right != null) temp.add(node.right);
// 			}
// 			q = temp;
// 			currentDepth++;
// 		}
// 		while(!q.isEmpty()) {
// 			TreeNode node = q.remove();
// 			TreeNode temp = node.left;
// 			node.left = new TreeNode(v);
// 			node.left.left = temp;
// 			temp = node.right;
// 			node.right = new TreeNode(v);
// 			node.right.right = temp;
// 		}
// 		return root;
// 	}
// }