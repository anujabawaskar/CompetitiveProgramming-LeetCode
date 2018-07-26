class Solution {
    public void setZeroes(int[][] matrix) {
        int rowZero = 0;
        int colZero = 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0)
                colZero = 1;
        }
        for(int i = 0; i < cols; i++) {
            if(matrix[0][i] == 0)
                rowZero = 1;
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < rows; i++) {
            if(matrix[i][0] == 0)
                nullifyRow(matrix, i);
        }
        for(int i = 1; i < cols; i++) {
            if(matrix[0][i] == 0)
                nullifyCol(matrix, i);
        }
        if(rowZero == 1)
            nullifyRow(matrix, 0);
        if(colZero == 1)
            nullifyCol(matrix, 0);
    }
    
    public void nullifyRow(int[][] matrix, int row) {
        for(int i = 0; i < matrix[0].length; i++ )
            matrix[row][i] = 0;
    }
    
    public void nullifyCol(int[][] matrix, int col) {
        for(int i = 0; i < matrix.length; i++ )
            matrix[i][col] = 0;
    }
}
