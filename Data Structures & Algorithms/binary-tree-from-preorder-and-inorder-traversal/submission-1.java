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

    private HashMap<Integer, Integer> in = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
        {
            in.put(inorder[i], i);
        }


        return build(preorder, 0, preorder.length-1, in, 0, inorder.length-1);
        
    }

    public TreeNode build(int[] pre, int st, int en, HashMap<Integer, Integer>in, int s, int e)
    {
        if(st > en || s > e)
        {
            return null;
        }

        TreeNode node = new TreeNode(pre[st]);

        int index = in.get(node.val);

        int leftSize = index - s;

        node.left = build(pre, st + 1, st + leftSize, in, s, index - 1);
        node.right = build(pre,st + 1 + leftSize, en, in, index + 1, e);

        return node;
    }
}
