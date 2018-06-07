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
    Integer min = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null)
            minDiffInBST(root.left);
        if(pre != null)
            min = Math.min(min, root.val - pre);
        pre = root.val;
        if(root.right != null)
            minDiffInBST(root.right);
        return min;
        
    }
}
