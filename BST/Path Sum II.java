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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(answer, list, root, sum);
        return answer;
    }
    public void helper(List<List<Integer>> answer, List<Integer> list, TreeNode root, int sum) {
        if(root == null)
            return;
        
        list.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0) {
            answer.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        
        helper(answer, list, root.left, sum - root.val);
        helper(answer, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}
