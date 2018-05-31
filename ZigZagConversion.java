class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1)
            return s;
        
        StringBuilder[] arr = new StringBuilder[numRows];   //create an array of StringBuilder, serves like a 2d array of char when initialised on line 9
        
        for(int i = 0; i < arr.length; i++)
            arr[i] = new StringBuilder("");
        
        int index = 0;  //row in 2-d array
        int factor = 1; //to increase/decrease row number
        
        for(int i = 0; i < s.length(); i++) {
            arr[index].append(s.charAt(i));
            if(index == 0)
                factor = 1; //inrease row by 1 so that the entire is filled out
            if(index == numRows - 1)
                factor = -1;    //decrease row
            index = index + factor;
        }
        
        String ans = "";
        //System.out.println(arr.length);
        for(int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            ans = ans + arr[i];
        }
        return ans;
        
    }    
}
