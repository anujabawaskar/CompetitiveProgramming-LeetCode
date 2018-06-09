class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m)
            return findMedianSortedArrays(nums2, nums1);
        
        //System.out.println(n + " " + m);
        int l = 0;
        int k = (m + n - 1) / 2;
        int r = Math.min(n, k);
        while(l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            //System.out.println(midA + " " + midB);
            if(nums1[midA] < nums2[midB])
                l = midA + 1;
            else
                r = midA;
        }
        
        int a = Math.max(l > 0 ? nums1[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? nums2[k - l] : Integer.MIN_VALUE);
        if((n + m) % 2 != 0)
            return (double)a;
        
        int b = Math.min(l < n ? nums1[l] : Integer.MAX_VALUE, k - l + 1 < m ? nums2[k - l + 1] : Integer.MAX_VALUE);
        
        return (a + b) / 2.0;
        
    }
}
