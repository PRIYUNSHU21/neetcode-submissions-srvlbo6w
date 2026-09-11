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
    public boolean isValidBST(TreeNode root) {

        if(root == null)
        {
            return true;
        }

        return checker(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

    public boolean checker(TreeNode node, long low, long high)
    {
        if(node.left != null && ( node.left.val <= low || node.left.val >= node.val))
        {
            return false;
        }
        else if(node.right != null && ( node.right.val <= node.val || node.right.val >= high))
        {
            return false;
        }

        return ((node.left != null) ? checker(node.left, low, node.val) : true) 
            && ((node.right != null) ? checker(node.right, node.val, high) : true);

        
    }
}
