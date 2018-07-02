class Solution {
    public String addBinary(String a1, String b1) {
        char[] a = a1.toCharArray();
        char[] b = b1.toCharArray();
        int len1 = a.length - 1;
        int len2 = b.length - 1;
        int carry = 0;
        int bit1 = 0;
        int bit2 = 0;
        StringBuffer sb = new StringBuffer();
        while(len1 >= 0 || len2 >= 0) {
            bit1 = len1 < 0 ? 0 : a[len1] - '0';
            bit2 = len2 < 0 ? 0 : b[len2] - '0';
            //System.out.println(bit1 + "   " + bit2);
            if(carry == 1) {
                if(bit1 == 1 && bit2 == 1) {
                    sb.insert(0, "1");
                    carry = 1;
                }
                else if(bit1 == 0 && bit2 == 0) {
                    sb.insert(0, "1");
                    carry = 0;
                }
                else {
                    sb.insert(0, "0");
                    carry = 1;
                }
            }
            else {
                if(bit1 == 1 && bit2 == 1) {
                    sb.insert(0, "0");
                    carry = 1;
                }
                else if(bit1 == 0 && bit2 == 0) {
                    sb.insert(0, "0");
                    carry = 0;
                }
                else {
                    sb.insert(0, "1");
                    carry = 0;
                }
            }
            len1--;
            len2--;
        }
        if(carry == 1)
            sb.insert(0, Integer.toString(carry));
        return sb.toString();
    }
}
