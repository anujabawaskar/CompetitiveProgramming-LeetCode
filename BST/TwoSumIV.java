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
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k, root);
    }
    
    public boolean helper(TreeNode root, int val, TreeNode curr) {
        if(root == null)
            return false;
        
        int rem = val - root.val;
        
        if(search(root, rem, curr))
            return true;
        
        return helper(root.left, val, curr) || helper(root.right, val, curr);
    }
    
    public boolean search(TreeNode root, int val, TreeNode curr) {
        if(curr == null)
            return false;
        if(curr.val == val && !root.equals(curr))
            return true;
        
        else if(curr.val > val)
            return search(root, val, curr.left);
        else
            return search(root, val, curr.right);
        
    }
}
