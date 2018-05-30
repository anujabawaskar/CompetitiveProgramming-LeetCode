class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0 || nums == null)
            return 0;
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i = 1; i < len; i++) {
            if(nums[i] < 0) {   // swap is needed as smaller number multiplied with negative is larger
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
            
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
