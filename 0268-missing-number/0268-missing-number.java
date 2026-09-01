class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expXOR = n;
        int actualXOR = 0;
        for(int i = 0; i<n;i++){
            expXOR ^=  i;
            actualXOR ^= nums[i];
        }
        return expXOR ^ actualXOR;
        
    }
}