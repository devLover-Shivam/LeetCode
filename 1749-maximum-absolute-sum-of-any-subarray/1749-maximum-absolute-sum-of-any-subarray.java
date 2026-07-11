class Solution {

    public int maxSum(int[] nums){
        int maxi = Integer.MIN_VALUE;
        //int mini = Integer.MAX_VALUE;
        int sum = 0;

        for(int i= 0;i<nums.length;i++){
            sum =  sum +nums[i];
            if(sum > maxi ){
                maxi = sum;
            }
            if(sum<0){
                sum = 0;
            }

        }

        return maxi;
    }

    public int minSum(int[] nums){
            int mini = Integer.MAX_VALUE;
            int sum = 0;
            for(int i = 0; i< nums.length;i++){
                sum = sum+nums[i];
                if(sum>0){
                    sum = 0;
                }
                if(sum<mini){
                    mini =sum;
                }

            }

            return Math.abs(mini);
    }

    public int maxAbsoluteSum(int[] nums) {
        if(maxSum(nums)>minSum(nums)) return maxSum(nums);
        else return minSum(nums);
    }


}