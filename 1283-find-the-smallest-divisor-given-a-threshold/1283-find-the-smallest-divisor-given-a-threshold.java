class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //Lowest Divisor Possible
        int low = 1;
        int high = nums[0];
        //Highest Divisor Possible
        for(int i=0;i<nums.length;i++){
            high = Math.max(nums[i],high);
        }

        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(sumOfD(nums,mid) <= threshold){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    private int sumOfD(int nums[],int div){
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum += (int)Math.ceil((double)nums[i]/div);
        }
        return sum;
    }
}