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

    public int count = 0; 

    public int goodNodes(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        count += 1;

        counter(root, root.val);

        return count;
        
    }

    public int counter(TreeNode root, int max)
    {
        if(root == null)
        {
            return 0;
        }

        if(root.left != null && root.left.val >= max)
        {
            count++;
        }
        if(root.right != null && root.right.val >= max)
        {
            count++;
        }

        if(root.left != null)
        {
            counter(root.left, Math.max(max, root.left.val));
        }
        else
        {
            counter(root.left, max);
        }
        if(root.right != null)
        {
            counter(root.right, Math.max(max, root.right.val));
        }
        else
        {
            counter(root.right, max);
        }

        return 0;
    }
}
