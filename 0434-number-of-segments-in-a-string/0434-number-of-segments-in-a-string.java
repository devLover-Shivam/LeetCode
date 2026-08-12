class Solution {
    public int countSegments(String s) {

        int segmentCount = 0;
        for(int i=0;i<s.length();i++){
            //kya current character ek non-space character hai AND kya ye word ka start hai?
            if(s.charAt(i)!=' ' && (i == 0 || s.charAt(i-1)== ' ')){
                segmentCount ++;
            }
        }

        return segmentCount;
    }
}