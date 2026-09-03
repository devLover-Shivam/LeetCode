class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n  = g.length;
        int m  = s.length;
        int l = 0;//left ptr at the cookie array
        int r = 0;//right ptr at the greed array

        while(l < m && r< n ){
            if(g[r] <= s[l]){
                r++;
            }
            l++;
        }
        return r;

        
    }
}