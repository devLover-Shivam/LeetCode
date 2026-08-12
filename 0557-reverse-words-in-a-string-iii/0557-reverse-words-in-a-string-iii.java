class Solution {
    public String reverseWords(String s) {
        char arr[] = s.toCharArray();
        int left = 0;
        int right = 0;
        while(left<s.length()){
            //find the end of the current word
            while(right<s.length() && s.charAt(right) != ' ') {
                right ++;
            }
            //reverse current word
            reverse(arr,left,right-1);
            //move to next word
            left = right + 1;
            right = left;
        }
        return new String(arr);
    }
    private void reverse(char[] s, int left, int right){
        int start = left;
        int end = right;

        while(start<end){
            swap(s,start,end);
            start++;
            end --;
        }

    }
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
}