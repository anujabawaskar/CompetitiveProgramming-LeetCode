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
    public int sumNumbers(TreeNode root) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root, 0);
        for(int n : list) {
            //System.out.println(n);
            answer = answer + n;
        }
        return answer;
    }
    
    public void helper(List<Integer> list, TreeNode root, int val) {
        if(root == null)
            return;
        val = val * 10 + root.val;
        if(root.left == null && root.right == null) {
            
            list.add(val);
            val = val / 10;
        }
        helper(list, root.left, val);
        helper(list, root.right, val);
        val = val / 10;
    }
}
