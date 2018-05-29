class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y; //take bits differing at the same position
        int count = 0; //count set bits 
        while(temp > 0) {
            temp = temp & (temp - 1);
            count++;
        }
        return count;
    }
}
