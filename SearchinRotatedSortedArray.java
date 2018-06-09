class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] <= nums[high]) {
                if(target > nums[mid] && target <= nums[high]) 
                    low = mid + 1;
                else
                    high = mid;
            }
            else {
                if(target >= nums[low] && target <= nums[mid]) {
                    high = mid;
                }
                else
                    low = mid + 1;
            }
        }
        return target == nums[low] ? low : -1;
    }
}
