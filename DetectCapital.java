class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        if(len < 2)
            return true;
        int flag = Character.isLowerCase(arr[0]) ? 0 : 1;   //0 - lower case and 1 - upper case
        int flag1 = Character.isLowerCase(arr[1]) ? 0 : 1;
        if(len == 2) {
            if(flag != flag1) {
                if(flag == 1)
                    return true;
                return false;
            }
            else
                return true;
        }
        for(int i = 1; i < len; i++) {
            int temp = Character.isLowerCase(arr[i]) ? 0 : 1;
            if(temp != flag1)
                return false;
        }
        if(flag == 1 && flag1 == 1) //all capital
            return true;
        if(flag == 1 && flag1 == 0) //like Google
            return true;
        if(flag == 0 && flag1 == 0) //all small
            return true;
        return false;
    }
}
