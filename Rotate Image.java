class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int layer = 0; layer < len / 2; layer++) {
            int first = layer;
            int last = len - 1 - layer;
            for(int i = first; i < last; i++) {
                int top = matrix[first][i];
                matrix[first][i] = matrix[len - i - 1][first];
                matrix[len - i - 1][first] = matrix[last][len - i -1];
                matrix[last][len - i - 1] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        
    }
}
