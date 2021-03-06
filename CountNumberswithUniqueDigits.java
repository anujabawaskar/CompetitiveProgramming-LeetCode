class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        
        int answer = 10;
        int available = 9;
        int unique = 9;
        while(n != 1 && available > 0) {
            unique = unique * available;
            answer = answer + unique;
            available--;
            n--;
        }
        return answer;
    }
}
