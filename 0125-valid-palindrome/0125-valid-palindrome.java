class Solution {
    public boolean isPalindrome(String s) {
        int left =0;
        int right = s.length() -1;
        while(left<right){
            //SKIPPING NON-ALPHANUMERIC CHARACTERS FROM LEFT
            while(left<right && (!Character.isLetterOrDigit(s.charAt(left)))){
                left++;
            }
            //SKIPPING NON-ALPHANUMERIC CHARACTERS FROM RIGHT
            while(left<right && (!Character.isLetterOrDigit(s.charAt(right)))){
                right --;
            }

            //COMPARING THE CONVERTED LOWERCASE CHARACTERS OF THE STRING
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;

        }

        return true;
    }
}