class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        int rows = matrix.length;
        if(matrix == null || matrix.length == 0)
            return new int[0];
        int cols = matrix[0].length;
        int[] answer = new int[rows * cols];
        int r = 0;
        int c = 0;
        int index = 0;
        answer[index] = matrix[0][0];
        index++;
        int reverse = 1;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while(r < rows - 1) {
            int r1 = r + 1;
            int c1 = 0;
            temp.clear();
            while(r1 >= 0 && r1 < rows && c1 >=0 && c1 < cols) {
                //System.out.println(matrix[r1][c1]);
                temp.add(matrix[r1][c1]);
                r1 = r1 - 1;
                c1 = c1 + 1;
            }
            if(reverse == 1) {
                //System.out.println("Here");
                Collections.reverse(temp);
                reverse = 0;
            }
            else {
                reverse = 1;
                //System.out.println("Here1");
            }
                
            for(int n : temp) 
                answer[index++] = n;
            
            r = r + 1;
        }
        //for(int i : answer)
            //System.out.println(i);
        int c2 = 0;
        int r2 = rows - 1;
        while(c2 < cols - 1) {
            int r3 = r2;
            int c3 = c2 + 1;
            temp.clear();
            while(r3 >= 0&& r3 < rows && c3 >=0 && c3 < cols) {
                //System.out.println(matrix[r3][c3]);
                temp.add(matrix[r3][c3]);
                r3 = r3 - 1;
                c3 = c3 + 1;
            }
            if(reverse == 1) {
                Collections.reverse(temp);
                reverse = 0;
            }
            else
                reverse = 1;
            for(int n : temp) 
                answer[index++] = n;
            
            c2 = c2 + 1;
        }
        return answer;
    }
}
