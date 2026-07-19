class Solution {

    public int lessThanEqualGoal(int[] nums, int goal) {
        if(goal<0) return 0;

        int l = 0, r = 0, sum = 0, cnt = 0;

        while(r<=nums.length-1){
            sum += (nums[r]%2);
            while(sum>goal){
                sum -= (nums[l]%2);
                l = l+1;
            }
            cnt = cnt+(r-l+1);
            r = r+1;
        }

        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return lessThanEqualGoal(nums,k) - lessThanEqualGoal(nums,k-1);
    }
}