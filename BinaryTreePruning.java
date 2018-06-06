/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if(ones(root))
            return root;
        else
            return null;
    }
    public boolean ones(TreeNode root) {
        if(root == null)
            return false;
        if(root.val == 1)
            return true;
        
        return ones(root.left) || ones(root.right);
    }
}
