class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int num = 1;
        for(int layer = 0; layer <= n / 2; layer++) {
            System.out.println("layer " + layer);
            for(int i = layer; i < n - layer; i++)
                m[layer][i] = num++;
            for(int i = layer + 1; i < n - layer; i++)
                m[i][n - 1 - layer] = num++;
            for(int i = n - layer - 2; i > layer; i--)
                m[n - 1 - layer][i] = num++;
            for(int i = n - 1 - layer; i > layer; i--)
                m[i][layer] = num++;
            
        }
        System.out.println(num);
        return m;
    }
}
