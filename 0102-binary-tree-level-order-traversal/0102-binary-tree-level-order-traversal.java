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
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) {
            return res;
        }

        q.offer(root);

        while(!q.isEmpty()) {
            int i = q.size();
            List<Integer> temp = new ArrayList<>();
            while(i > 0) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!=null) {
                    q.offer(curr.left);
                }
                if(curr.right!=null) {
                    q.offer(curr.right);
                }
                i--;
            }
            res.add(temp);
        }
        return res;
    }
}