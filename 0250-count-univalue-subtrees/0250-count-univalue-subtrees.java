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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUni(root);
        return count;
    }

    public boolean isUni(TreeNode node) {
        if(node == null) {
            return true;
        }

        boolean isLeftUni = isUni(node.left);
        boolean isRightUni = isUni(node.right);

        if(!isLeftUni || !isRightUni) {
            return false;
        }

        if(node.left != null && node.left.val != node.val ) {
            return false;
        }
        if(node.right !=null && node.right.val != node.val) {
            return false;
        }

        count++;
        return true;
    }
}