class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int children = g.length;
        int cookies = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = children - 1;
        int j = cookies - 1;
        int count = 0;
        while(i >= 0 && j >= 0) {
            if(s[j] >= g[i]) {
                i--;
                j--;
                count++;
            }
            else {
                i--;
            }
        }
        return count;
        
    }
}
