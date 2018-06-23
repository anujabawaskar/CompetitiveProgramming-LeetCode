class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int low = 0;
        int high = nums.length - 1;
        int[] answer = {-1, -1};
        while(low < high) {
            int mid = (low + high) / 2;
            if(target > nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        if(nums[low] != target)
            return answer;
        answer[0] = low;
        high = nums.length - 1;
        while(low < high) {
            int mid = (low + high) / 2 + 1;
            if(target < nums[mid])
                high = mid - 1;
            else
                low = mid;
        }
        answer[1] = high;
        return answer;
    }
}
