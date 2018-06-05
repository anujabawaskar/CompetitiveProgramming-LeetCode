class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < len - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            if(nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)    //nums[i] is not going to contribute to target
                continue;
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)  //no more solutions are possible
                break;
            
            for(int j = i + 1; j < len - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)  //nums[j] is more than the target, check for next possibility of i
                    break;
                if(nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target)  //nums[j] is less than target, go to nums[j + 1]
                    continue;
                
                int start = j + 1;
                int end = len - 1;
                //now 3 sum logic
                while(start < end) {
                    int temp = nums[i] + nums[j] + nums[start] + nums[end];
                    if(temp < target)
                        start++;
                    else if(temp > target)
                        end--;
                    else {
                        ArrayList<Integer> res = new ArrayList<Integer>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[start]);
                        res.add(nums[end]);
                        answer.add(new ArrayList<>(res));
                        start++;
                        end--;
                        while(nums[start] == nums[start - 1] && start < end)
                            start++;
                        while(nums[end] == nums[end + 1] && start < end)
                            end--;
                    }
                }
            } 
        }
        return answer;
    }
}
