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
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return goodNodes;
    }

    public void dfs(TreeNode root, int maxSeen) {
        if(root == null) return;

        if(maxSeen <= root.val) goodNodes++;

        maxSeen = Math.max(maxSeen, root.val);

        dfs(root.left, maxSeen);
        dfs(root.right, maxSeen);
    }
}