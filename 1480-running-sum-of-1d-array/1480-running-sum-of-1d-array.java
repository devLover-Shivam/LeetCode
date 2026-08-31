class Solution {
    public int[] runningSum(int[] nums) {
        int rs[] = new int[nums.length];
        rs[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            rs[i] = rs[i-1]+nums[i];
        }
        return rs;
    }
}