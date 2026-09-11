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

    public int h = -1;
    
    public int kthSmallest(TreeNode root, int k) {

        h=k;

        int result = inorder(root);

        return result;
        
    }

    public int cont = -1;

    public int inorder(TreeNode root)
    {
        if(root == null)
        {
            return cont;
        }

        inorder(root.left);
        h--;
        if(h == 0)
        {
            cont = root.val;
        }
        inorder(root.right);

        return cont;
    }
}
