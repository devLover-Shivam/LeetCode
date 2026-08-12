class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int sp = 0;
        int ep = n-1;
        while(sp<ep){
            swap(s,sp,ep);
            sp++;
            ep--;
        }
    }

    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}