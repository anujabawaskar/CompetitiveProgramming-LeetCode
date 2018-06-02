class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int dist = 0;
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if(i == dist) { //if we reach an index that can be reached from jumping from a prev index
                steps++;    
                dist = max; //go to the maximum index that can be reached from the already visited indexes.
            }
        }
        return steps;
    }
}
