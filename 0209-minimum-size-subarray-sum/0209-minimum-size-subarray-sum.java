class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int i = 0;
        int sum  = 0;
        for(int j = i;j<nums.length;j++){
                sum += nums[j];
                while(sum >= target){
                minSize = Math.min(minSize, j-i+1);
                sum -= nums[i];
                i++;
                }
        }
        return minSize == Integer.MAX_VALUE? 0: minSize;
    }
}