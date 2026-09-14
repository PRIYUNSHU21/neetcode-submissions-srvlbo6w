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

    public int max_value = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        calculate(root);

        return max_value;   
    }

    public int calculate(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int left = Math.max(0,calculate(node.left));
        int right = Math.max(0, calculate(node.right));

        if(node.val + left + right >= max_value)
        {
            max_value = node.val + left + right;
        }

        return node.val + Math.max(left,right);
    }
}
