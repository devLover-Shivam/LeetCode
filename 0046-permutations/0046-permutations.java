class Solution {
    private void swap(int nums[],int idx, int i){
        int temp = nums[idx];
        nums[idx]= nums[i];
        nums[i] = temp;
    }
    private void getPerms(int nums[],int idx, List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> currPerm = new ArrayList<>();
            for(int num: nums){
                currPerm.add(num);
            }
            ans.add(currPerm);
            return;
        }
        for(int i= idx;i<nums.length;i++){
            //ith element choice
            swap(nums,idx,i);
            getPerms(nums,idx+1,ans);
            //bacltracking
            swap(nums,idx,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        getPerms(nums,0,ans);
        return ans;
    }
}