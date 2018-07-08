class Solution {
    int cr = 0;
    int cl = 0;
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if(row * col != r * c)
            return nums;
        
        int[][] m = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                    m[i][j] = get(row, col, nums);                        
            }
        }
        return m;
    }
    public int get(int row, int col, int[][] nums) {
        int temp;
        if(cl < col) {
            temp = nums[cr][cl];
            cl = cl + 1;
            return temp;
        }
            
        else {
            cr = cr + 1;
            cl = 0;
            temp = nums[cr][cl];
            cl = cl + 1;
            return temp;
        }
    }
}
