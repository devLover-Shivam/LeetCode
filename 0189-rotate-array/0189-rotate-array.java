class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //no of effective rotations
        k = k% n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums, int sp, int ep){
        while(sp<ep){
            swap(nums,sp,ep);
            sp++;
            ep--;
        }
    }

    public void swap(int[] nums,int sp, int ep){
        int temp = nums[sp];
        nums[sp] = nums[ep];
        nums[ep] = temp;
    }
}