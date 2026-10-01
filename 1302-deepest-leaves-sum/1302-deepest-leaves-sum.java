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
    public int deepestLeavesSum(TreeNode root) {
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque(),
        currLevel = new ArrayDeque();

        nextLevel.offer(root);
        
        while(!nextLevel.isEmpty()) {
            currLevel = nextLevel.clone();
            nextLevel.clear();

            for(TreeNode node: currLevel) {
                if(node.left != null) {
                    nextLevel.offer(node.left);
                }
                if(node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
        }

        int deepSum = 0;
        for(TreeNode node : currLevel) {
            deepSum += node.val;
        }

        return deepSum;
    }
}