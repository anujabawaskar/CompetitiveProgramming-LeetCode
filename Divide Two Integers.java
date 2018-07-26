class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        
        if((dividend > 0) ^ (divisor > 0))
            sign = -1;
        
        long num = Math.abs((long)dividend);
        long den = Math.abs((long)divisor);
        
        if(num == 0 || num < den)
            return 0;
        
        long quo = ldivide(num, den);
        
        
        if(quo > Integer.MAX_VALUE)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        
        return (int)(sign * quo);
        
    }
    public long ldivide(long num, long den) {
        
        if(num < den)
            return 0;
        
        long sum = den;
        long multiple = 1;
        while((sum + sum) <= num) {
            sum = sum + sum;
            multiple = multiple + multiple;
        }
        
        return multiple + ldivide(num - sum, den);
    }
}
