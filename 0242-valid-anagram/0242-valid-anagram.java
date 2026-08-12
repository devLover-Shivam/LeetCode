class Solution {
    public boolean isAnagram(String s, String t) {
        int freq[] = new int[26];
        //anagrams must have equal length
        if (s.length() != t.length()) return false;

        // for string s increasing the frequency
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a'] ++;
        }
        //for string t decreasing the frequency
        for(int i =0;i<t.length();i++){
            freq[t.charAt(i)-'a'] --;
        }
        //now if any of the freq elements is not equal to 0 return false
        for(int i = 0;i<26;i++){
            if(freq[i] != 0) return false;
        }

        return true;
    }
}