class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix == null)
            return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] arr = new int[rows][cols];
        int max = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int len = helper(arr, matrix, i, j, rows, cols);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    public int helper(int[][] arr, int[][] mat, int i, int j, int rows, int cols) {
        if(arr[i][j] != 0)
            return arr[i][j];
        
        int max = 1;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= rows || y < 0 || y >= cols || mat[x][y] <= mat[i][j]) {
                continue;
            }
            int len = 1 + helper(arr, mat, x, y, rows, cols);
            max = Math.max(max, len);
        }
        arr[i][j] = max;
        return max;
    }
}
