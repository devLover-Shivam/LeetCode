class Solution {
    public int splitArray(int[] nums, int k) {
        //impossible case when partition isn't possible
        if(k>nums.length)  return -1;
        //lowest value possible for the maximum sum
        long low = 0;
        for(int i=0;i<nums.length;i++){
            low = Math.max(nums[i],low);
        }
        //highest value possible for the maximum sum
        long high = 0;
        for(int i=0;i<nums.length;i++){
            high += nums[i];
        }

        while(low<=high){
            long mid = low+(high-low)/2;
            int noOfSplits = func(nums,mid);
            if(noOfSplits>k) low = mid+1;
            else high = mid-1;
        }
        return (int)low;
    }

    private int func(int arr[],long sum){
        long maxSum = 0;
        int splits = 1;
        for(int i=0;i<arr.length;i++){
            if(maxSum+arr[i]<=sum){
                maxSum+= arr[i];
            }
            else{
                splits++;
                maxSum = arr[i];
            }
        }
        return splits;
    }
}