class Solution {
    private void func(int nums[],int i, List<List<Integer>> subsetsWithoutDup, ArrayList<Integer> currSubset){
        if(i == nums.length){
            subsetsWithoutDup.add(new ArrayList<>(currSubset));
            return;
        }
        //pick the current element
        currSubset.add(nums[i]);
        func(nums,i+1,subsetsWithoutDup,currSubset); 

        currSubset.remove(currSubset.size()-1);
        //skip the duplicate elements as it will create repetitive subsets
        int index = i+1;
        while(index<nums.length && nums[index] == nums[index-1]){
            index++;
        }
        //not pick the current element
        
        func(nums,index,subsetsWithoutDup,currSubset);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetsWithoutDup = new ArrayList<>();
        ArrayList<Integer> currSubset = new ArrayList<>();
        Arrays.sort(nums);
        func(nums,0,subsetsWithoutDup,currSubset);
        return subsetsWithoutDup;
    }
}