class Solution {

    public int lessThanEqualGoal(int[] nums, int goal) {
        if(goal<0) return 0;

        int l = 0, r = 0, sum = 0, cnt = 0;

        while(r<=nums.length-1){
            sum += nums[r];
            while(sum>goal){
                sum -= nums[l];
                l = l+1;
            }
            cnt = cnt+(r-l+1);
            r = r+1;
        }

        return cnt;
    }

    

    public int numSubarraysWithSum(int[] nums, int goal) {

        return lessThanEqualGoal(nums,goal) - lessThanEqualGoal(nums,goal-1);
    }

    
}