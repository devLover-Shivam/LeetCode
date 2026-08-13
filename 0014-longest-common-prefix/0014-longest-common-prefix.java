class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i =0;i<strs[0].length();i++){
            //taking the characters of the first element of string array i.e. str[0] as the reference for comparison
            char ch = strs[0].charAt(i);

            //now comparing each character with the current string element
            for(int j = 1;j<strs.length;j++){

                if(i>= strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0,i);
                }

            }           

        }

         return strs[0];
    }
}