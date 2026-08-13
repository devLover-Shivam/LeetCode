class Solution {
    public String removeDuplicates(String s) {

        //following the stack pattern by using stringbuilder to avoid the overhead for conversion of stack into string answer.
        StringBuilder st = new StringBuilder();

        for(char ch: s.toCharArray()){
            //if stack is not empty and the current character isequal to the top element then dont push the current character as well delete the top character
            if(st.length()>0 && st.charAt(st.length()-1)==ch){
                st.deleteCharAt(st.length()-1);
            }
            //keep on adding the current unique character to the mutable stringbuilder data structure 'st'
            else{

                st.append(ch);
            }
        }
        //finally converting the stringbuilder to string
        return st.toString();
    }
}