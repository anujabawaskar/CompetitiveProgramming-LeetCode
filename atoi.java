public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        //System.out.println(str);
        char[] arr = str.toCharArray();
        if(arr.length <= 0)
            return 0;
        int index = 0;
        if((arr[0] - '0' >= 0 && arr[0] - '0' <= 9) || arr[0] == '+' || arr[0] == '-') {
            int res = 0;
            int oldRes = 0;
            int flag = 0;
            if(arr[0] == '+') {
                index++;
                flag = 1;
            }
            if(arr[0] == '-') {
                index++;
                flag = 2;
            }
           // System.out.println(flag);
            for(int i = index; i < arr.length; i++) {
                if(arr[i] >= 48 && arr[i] <= 57) {
                    int val = arr[i] - '0';
                    
                    if(Integer.MAX_VALUE/10 < res || (Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE % 10 < val))
                        return flag == 2 ? Integer.MIN_VALUE : Integer.MAX_VALUE  ;
                    
                    res = res * 10 + val;
                }
                else break;
            }
            System.out.println("outside");
            if(flag == 2)
                return res * -1;
            return res;
        }
        return 0;
    }
}
