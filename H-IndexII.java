class Solution {
    public int hIndex(int[] citations) {
        int total = citations.length;
        int left = 0;
        int right = total - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right)/ 2;
            if(citations[mid] == (total - mid))
                return citations[mid];
            else if(citations[mid] > (total - mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return total - left;
    }
}
