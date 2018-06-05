class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int len = nums.length;
        int sum = nums[0] + nums[1] + nums[len - 1];    //cannot be integer.max as the condition check may overflow and give strange results
        if(nums == null || len < 3)
            return 0;
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if(temp < target)
                    j++;
                else
                    k--;
                if (Math.abs(temp - target) < Math.abs(sum - target)) 
                    sum = temp;
            }
        }
        return sum;
    }
}
