class Solution {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x) {
            val = x;
        }
    }
    TreeNode root;
    TreeNode succ;
    public TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if(val < root.val) {
            succ = root;
            root.left = insert(root.left,  val);
        }
        else
            root.right = insert(root.right, val);
        
        return root;
    }
    
    public int[] replaceNext(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        for(int i = len - 1; i >= 0; i--) {
            succ = null;
            root = insert(root, nums[i]);
            
            if(succ != null)
                answer[i] = succ.val;
            else
                answer[i] = -1;
        }
        return answer;
    }
    public static void main(String args[]) {
        int[] num = {5,2,6,1};
        Solution obj = new Solution();
        int[] ans = obj.replaceNext(num);
        for(int n : ans)
            System.out.println(n);
    }
}
