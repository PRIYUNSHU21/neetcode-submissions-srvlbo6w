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
    public boolean isBalanced(TreeNode root) {
        
        int x = calculate(root);

        if(x == -1)
        {
            return false;
        }
        return true;
    }

    public int calculate(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int left = calculate(root.left);
        if(left == -1) return -1;
        int right = calculate(root.right);
        if(right == -1)return -1;

        if(left - right > 1)
        {
            return -1;
        }
        else if(right - left > 1)
        {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}

