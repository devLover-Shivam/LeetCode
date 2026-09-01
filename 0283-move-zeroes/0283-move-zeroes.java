class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        //finding the first zero element and placing the j pointer there
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        //it means there are no zero elements present in the array and we can return with the original array.
        if( j == -1) return;
        //now swapping the non-zero elements with the zeroe elements
        for(int i = j+1;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                //now move the j pointer to next zero element
                j++;
            }
        }
    }
}