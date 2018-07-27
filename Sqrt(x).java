class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;
        
        int left = 1;
        int right = x;
        int ans = 1;
        
        while(left <= right) {
            
            int mid = (left + right) / 2;
            
            if(mid == x / mid)
                return mid;
            
            if(mid > x /mid)
                right = mid - 1;
            
            else {
                ans = mid;
                left = mid + 1;
            }
            
        }
        return ans;
    }
}
