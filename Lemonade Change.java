class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        for(int b : bills) {
            if(b == 5)
                count5++;
            else if(b == 10) {
                count10++;
                if(count5 > 0)
                    count5--;
                else
                    return false;
            }
            else {
                count20++;
                if(count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                }
                else if(count5 > 3)
                    count5 = count5 - 3;
                else
                    return false;
            }
        }
        return true;
    }
}
