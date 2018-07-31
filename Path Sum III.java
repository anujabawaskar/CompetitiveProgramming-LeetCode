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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        helper(map, root, sum, 0);
        return count;
    }
    public void helper(HashMap<Integer, Integer> map, TreeNode root, int target, int curr) {
        if(root == null)
            return;
        
        curr = curr + root.val;
        if(map.containsKey(curr - target))
            count = count + map.get(curr - target);
        
        if(!map.containsKey(curr))
            map.put(curr, 1);
        else
            map.put(curr, map.get(curr) + 1);
        
        helper(map, root.left, target, curr);
        helper(map, root.right, target, curr);
        map.put(curr, map.get(curr) - 1);
    }
}
