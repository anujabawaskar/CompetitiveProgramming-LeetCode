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
    int maxCount = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    //sum to frequency map
    
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);   //this function will find sum at each node and populate the map in postorder fashion
        
        List<Integer> list = new ArrayList<Integer>();
        for(int key : map.keySet()) {
            if(map.get(key) == maxCount)
                list.add(key);
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for(int n : list)
            answer[index++] = n;
        return answer;
    }
    
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int sum = left + right + root.val;
        int count = 0;
        
        if(!map.containsKey(sum)) {
            map.put(sum, 1);
            count = 1;
        }
        else {
            count = map.get(sum) + 1;
            map.put(sum, count);
        }
        
        maxCount = Math.max(maxCount, count);
        return sum;
    }
}
