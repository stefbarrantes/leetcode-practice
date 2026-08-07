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
    class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 1));
        
        int maxD = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            maxD = Math.max(maxD, current.depth);

            if (current.node.right != null)
                queue.offer(new Pair(current.node.right, current.depth + 1));

            if (current.node.left != null)
                queue.offer(new Pair(current.node.left, current.depth + 1));
        }

        return maxD;
    }
}