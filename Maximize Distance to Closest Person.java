class Solution {
    public int maxDistToClosest(int[] seats) {
        int all = seats.length;
        int prev = -1;
        int future = 0;
        int max = 0;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) 
                prev = i;
            if(seats[i] == 0) {
                while(future < all && seats[future] == 0 || future < i)
                    future++;
                
                int left = prev == -1 ? all : i - prev;
                int right = future == all ? all : future - i;
                max = Math.max(max, Math.min(left,right));
            }
        }
        return max;
    }
}
