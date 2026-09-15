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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==  null)
        {
            return null;
        }
        StringBuilder result = new StringBuilder();

        preorder(root, result);

        return result.toString();
    }

    public void preorder(TreeNode node, StringBuilder result)
    {
        if(node == null)
        {
            result.append("n,");
            return;
        }
        else
        {
            result.append(node.val).append(",");
        }
       preorder(node.left, result);
       preorder(node.right, result);
    }

    public int i  = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null || data.isEmpty())
        {
            return null;
        }

        String[] temp = data.split(",");

        return helper(temp, data.length() -1);
        
    }
    public TreeNode helper(String[] temp, int size) {
        
       if(temp[i].equals("n") || i > size)
       {
          i++;
          return null;
       }
       TreeNode node = new TreeNode();

       node.val = Integer.parseInt(temp[i]);
       i++;

       node.left = helper(temp, size);
       node.right = helper(temp, size);

       return node;
        
    }

}
