class Solution {
    public int compress(char[] chars) {
        int start = 0;
        int end = 0;
        int write = 0;

        while(end<chars.length){
            //finding the complete window of same characters 
            while(end<chars.length && chars[start]==chars[end]){
                end++;
            }
            //current character ka window count
            int count = end -start;
            //character ko write karo original array me
            chars[write] = chars[start];
            //agle write k liye write ka index aage badhao
            write++;
            //write count only if count > 1
            if(count>1) {
                String countString = String.valueOf(count);
                for(char ch : countString.toCharArray()){
                    chars[write] = ch;
                    write++;
                }
            }
            //move start to next group
            start = end;
        }
        return write;
    }
}