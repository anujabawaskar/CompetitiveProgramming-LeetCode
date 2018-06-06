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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if(root == null)
            return answer;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while(size != 0) {
                TreeNode temp = q.remove();
                max = Math.max(max, temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                size--;
            }
            answer.add(max);
        }
        return answer;
    }
}
