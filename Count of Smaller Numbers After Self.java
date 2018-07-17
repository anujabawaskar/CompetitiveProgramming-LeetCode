class Solution {
    class TreeNode {
        TreeNode left; 
        TreeNode right;
        int val;
        int count = 1;
        public TreeNode(int val) {
            this.val = val;
        }
    }
       
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return answer;
        
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len - 1]);
        answer.add(0);
        for(int i = len - 2; i >= 0; i--) {
            int count = create(root, nums[i]);
            answer.add(count);
        }
        Collections.reverse(answer);
        return answer;
        
    }
    public int create(TreeNode root, int val) {
        int curr = 0;
        while(true) {
            if(val <= root.val) {   //new smaller element found, update count 
                root.count++;
                if(root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                }
                else
                    root = root.left;
            }
            else {  //add count of current node to the curr count. 
                curr = curr + root.count;
                if(root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                }
                else
                    root = root.right;
            }
        }
        return curr;
        
    }
}
