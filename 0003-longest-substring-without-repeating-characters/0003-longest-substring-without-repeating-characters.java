class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hashLen = 256;
        int n = s.length();

        int hash[] = new int[hashLen];

        int l = 0, r = 0 , len = 0, maxLen = 0;
        Arrays.fill(hash,-1);
        while(r<n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)]+1;
                }
            }

            len = r-l+1;
            maxLen = Math.max(len,maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }

        return maxLen;
    }
}