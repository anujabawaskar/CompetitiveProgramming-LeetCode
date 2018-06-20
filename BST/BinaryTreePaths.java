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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if(root == null)
            return answer;
        helper(root, answer, "");
        return answer;
    }
    public void helper(TreeNode root, List<String> answer, String s) {
        if(root.left == null && root.right == null)
            answer.add(s + root.val);
        if(root.left != null)
            helper(root.left, answer, s + root.val + "->" );
        if(root.right != null)
            helper(root.right, answer, s + root.val + "->" );
    }
}
