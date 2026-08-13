class Solution {
    public String reverseWords(String s) {
        s = new StringBuilder(s).reverse().toString();

        StringBuilder ans  = new StringBuilder();


        for(int i = 0; i<s.length();i++){
           StringBuilder word  = new StringBuilder();

            while(i<s.length() && s.charAt(i) !=' '){
                word.append(s.charAt(i));
                i++;
            }

            word.reverse();

            if(word.length()>0){
                ans.append(" ").append(word);
            }
        }

        return ans.substring(1);
    }
}