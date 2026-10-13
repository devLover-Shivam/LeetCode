class Solution {
     void func(int nums[],ArrayList<Integer> powerSet,int i,List<List<Integer>> ans){
        if(i== nums.length){
            ans.add(new ArrayList<>(powerSet));
            return;
        }
        //Pick
        powerSet.add(nums[i]);
        func(nums,powerSet,i+1,ans);
        //Backtrack
        powerSet.remove(powerSet.size()-1);
        //Not Pick
        func(nums,powerSet,i+1,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> powerSet = new ArrayList<>();
        func(nums,powerSet,0,ans);
        return ans;
    }
}