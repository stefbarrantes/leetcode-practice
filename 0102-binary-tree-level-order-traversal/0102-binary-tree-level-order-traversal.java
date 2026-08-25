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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        
        if(root == null) return res; 

        que.offer(root); 

        while(!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode cur = que.poll();
                level.add(cur.val);

                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right); 
            }
            
            res.add(level);         
        }

        return res;        
    }
}