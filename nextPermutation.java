class Solution {
    public void nextPermutation(int[] nums) {
        int k = -1;
        int len = nums.length;
        for(int i = len - 2; i >= 0; i--) {
            if(nums[i + 1] > nums[i]) {
                k = i;
                break;
            }
        }
        if(k == -1) {
            System.out.println("Call");
            reverse(nums, 0, len - 1);
            return;
        }
        
        int l = -1;
        for(int i = len - 1; i > k; i--) {
            if(nums[i] > nums[k]) {
                l = i;
                break;
            }
        }
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
        
        reverse(nums, k + 1, len - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
