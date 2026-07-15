class Solution {
    public void nextPermutation(int[] nums) {
        int n  = nums.length;
        int index = -1;

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index  = i;
                break;
            }
        }

        if(index == -1) {
            reverse(nums,index+1,n-1);
            return;
        }

        for(int i = n-1;i>=0;i--){
            if(nums[i]>nums[index]){
                swap(nums,index,i);
                break;
            }
        }

        reverse(nums,index+1,n-1);
    }

    private void swap(int nums[],int index, int i){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    private void reverse(int nums[], int start, int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

}